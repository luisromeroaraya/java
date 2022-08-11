package com.example.demorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable(); // we disable this to avoid csrf errors
        http.sessionManagement().sessionCreationPolicy((SessionCreationPolicy.STATELESS));
        http.authorizeRequests()
                .antMatchers("/security/test/all").permitAll()
                .antMatchers("/security/test/nobody").denyAll()
                .antMatchers("/security/test/connected").authenticated()
                .antMatchers("/security/test/not-connected").anonymous()
                .antMatchers("/security/test/role/user").hasRole("USER")
                .antMatchers("/security/test/role/admin").hasRole("ADMIN")
                .antMatchers("/security/test/role/any").hasAnyRole("USER", "ADMIN")
                .antMatchers("/security/test/authority/read").hasAuthority("ROLE_USER")
                .antMatchers("/security/test/authority/any").hasAnyAuthority("ROLE_USER", "READ", "WRITE")
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .antMatchers("/reservations/check-date").permitAll()
                .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("user")
                .password(encoder().encode("password"))
                .roles("USER")
                .build());
        manager.createUser(User
                .withUsername("admin")
                .password(encoder().encode("password"))
                .roles("ADMIN")
                .build());
        return manager;
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

// LES DROITS:

// - permitAll : tous les visiteurs (connectés ou pas)
// - denyAll : personne
// - authenticated : connecté
// - anonymous : pas connecté
// - hasRole : possède le rôle particulier (un rôle est une autorité commencant par ROLE_)
// - hasAnyRole : possède au moins un des rôles mentionnés
// - hasAuthority : possède l'authorité particulier
// - hasAnyAuthorities : possède au moins une des authorités mentionnés

// - not(): methode avant un droit donnée pour un chemin pour obtenir l'opposé


// ROLES POSSIBLES:

// - ADMIN
// - USER

// AUTHORITES POSSIBLES:

// - RECUPERER
// - MODIFIER

// LIAISONS:

// - ADMIN: RECUPERER et MODIFIER et ROLE_ADMIN
// - USER: RECUPERER et ROLE_USER

// je peux utiliser:
// - ? : joker pour de 0 à 1 caractère
// - * : joker pour un segment de 0 à N caractères
// - **: joker pour de 0 à N segments
// - {pathVar:regex}: pattern regex pour un segment