package com.example.exosecurity.services.implementation;

import com.example.exosecurity.models.entities.User;
import com.example.exosecurity.models.forms.UserAddForm;
import com.example.exosecurity.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public CustomUserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible."));
    }

    public void addUser(UserAddForm form) {
        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}