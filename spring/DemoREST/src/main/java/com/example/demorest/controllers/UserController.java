package com.example.demorest.controllers;

import com.example.demorest.models.forms.UserAddForm;
import com.example.demorest.services.implementation.CustomUserDetailsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private CustomUserDetailsServiceImpl userService;

    @PostMapping("/add")
    public void createUser(@Valid @RequestBody UserAddForm form) {
        userService.addUser(form.toEntity());
    }
}
