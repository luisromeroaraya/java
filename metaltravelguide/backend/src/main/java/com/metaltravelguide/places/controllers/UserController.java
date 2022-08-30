package com.metaltravelguide.places.controllers;

import com.metaltravelguide.places.models.dtos.UserDTO;
import com.metaltravelguide.places.models.forms.UserAddForm;
import com.metaltravelguide.places.models.forms.UserLoginForm;
import com.metaltravelguide.places.models.forms.UserUpdateForm;
import com.metaltravelguide.places.services.implementation.CustomUserDetailsServiceImpl;
import com.metaltravelguide.places.tools.JWTProvider;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CustomUserDetailsServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    public UserController(CustomUserDetailsServiceImpl userService, AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public void addUser(@Valid @RequestBody UserAddForm form) {
        userService.add(form);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserLoginForm form) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return jwtProvider.createToken(auth);
    }
    @GetMapping("/profile")
    @Secured({"ROLE_USER"})
    public UserDTO profile(Authentication authentication) {
        return userService.getOne(authentication.getName());
    }

    @PatchMapping("/update")
    @Secured({"ROLE_USER"})
    public UserDTO update(@Valid @RequestBody UserUpdateForm form, Authentication authentication) {
        form.setUsername(authentication.getName());
        return userService.update(form);
    }
}
