package com.metaltravelguide.places.controllers;

import com.metaltravelguide.places.models.forms.UserAddForm;
import com.metaltravelguide.places.models.forms.UserLoginForm;
import com.metaltravelguide.places.services.implementation.CustomUserDetailsServiceImpl;
import com.metaltravelguide.places.tools.JWTProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    private final CustomUserDetailsServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    public UserController(CustomUserDetailsServiceImpl userService, AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping
            ("/register")
    public void addUser(@Valid @RequestBody UserAddForm form) {
        userService.addUser(form);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserLoginForm form) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return jwtProvider.createToken(auth);
    }

    @GetMapping("/profile")
    public String profile(Authentication auth) {
        return auth.getName();
    }
}