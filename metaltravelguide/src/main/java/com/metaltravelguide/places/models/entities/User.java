package com.metaltravelguide.places.models.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users") // a table named "user" can't be created, you have to rename it "users" here
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(columnDefinition = "CHAR(2)")
    private String country_iso;
    private boolean enabled = true;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = List.of("USER");

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Place> places = new HashSet<>();

    public User(String username, String password, String mail, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public User(String username, String password, String mail, String first_name, String last_name, String country_iso) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country_iso = country_iso;
    }

    public User(String username, String password, String mail, String first_name, String last_name, String country_iso, List<String> roles) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country_iso = country_iso;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map((role) -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
