package com.example.demorest.controllers;

import com.example.demorest.models.dto.TokenDTO;
import com.example.demorest.models.dto.UserDTO;
import com.example.demorest.models.forms.UserCreateForm;
import com.example.demorest.models.forms.UserLoginForm;
import com.example.demorest.services.implementation.CustomUserDetailsServiceImpl;
import com.example.demorest.tools.JWTProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody UserCreateForm userCreateForm) {
        userService.addUser(userCreateForm);
    }

    @PostMapping("/login")
    public TokenDTO login(@Valid @RequestBody UserLoginForm form){
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        return new TokenDTO(jwtProvider.createToken(auth));
    }

    @GetMapping("/all")
    @Secured({"ROLE_ADMIN"})
    public List<UserDTO> getUsers() {
        return userService.getUsersByRole("USER");
    }
}
