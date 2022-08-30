package com.metaltravelguide.places.services.implementation;

import com.metaltravelguide.places.exceptions.ElementNotFoundException;
import com.metaltravelguide.places.mappers.UserMapper;
import com.metaltravelguide.places.models.dtos.UserDTO;
import com.metaltravelguide.places.models.entities.Place;
import com.metaltravelguide.places.models.entities.User;
import com.metaltravelguide.places.models.forms.UserAddForm;
import com.metaltravelguide.places.models.forms.UserUpdateForm;
import com.metaltravelguide.places.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public CustomUserDetailsServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible."));
    }

    public UserDTO getOne(String username) {
        return userMapper.toDto(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connection not possible.")));
    }

    public void add(UserAddForm form) {
        User user = userMapper.toEntity(form);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserDTO update(UserUpdateForm form) {
        User user = userRepository.findByUsername(form.getUsername())
                .orElseThrow(() -> new ElementNotFoundException(User.class, form.getUsername()));
        if (form.getPassword() != null)
            user.setPassword(encoder.encode(form.getPassword()));
        if (form.getMail() != null)
            user.setMail(form.getMail());
        if (form.getFirstName() != null)
            user.setFirstName(form.getFirstName());
        if (form.getLastName() != null)
            user.setLastName(form.getLastName());
        if (form.getCountryIso() != null)
            user.setCountryIso(form.getCountryIso());
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}