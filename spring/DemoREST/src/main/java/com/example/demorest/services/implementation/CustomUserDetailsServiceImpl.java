package com.example.demorest.services.implementation;

import com.example.demorest.mapper.UserMapper;
import com.example.demorest.models.dto.UserDTO;
import com.example.demorest.models.entities.User;
import com.example.demorest.models.forms.UserCreateForm;
import com.example.demorest.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    public CustomUserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder encoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible."));
    }

    public List<UserDTO> getUsersByRole(String role) {
        return userRepository.findUsersByRole(role).stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void addUser(UserCreateForm form) {
        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
