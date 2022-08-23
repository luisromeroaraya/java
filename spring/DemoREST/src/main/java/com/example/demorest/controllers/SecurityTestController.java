package com.example.demorest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security/test")
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityTestController {
    @GetMapping("/all")
    public String allAccess() {
        return "ok";
    }

    @GetMapping("/nobody")
    public String nobody() {
        return "ok";
    }

    @GetMapping("/connected")
    public String connected() {
        return "ok";
    }

    @GetMapping("/not-connected")
    public String notConnected() {
        return "ok";
    }

    @GetMapping("/role/user")
    public String roleUser() {
        return "ok";
    }

    @GetMapping("/role/admin")
    public String roleAdmin() {
        return "ok";
    }

    @GetMapping("/role/any")
    public String roleAny() {
        return "ok";
    }

    @GetMapping("/authority/read")
    public String hasReadAuthority() {
        return "ok";
    }

    @GetMapping("/authority/any")
    public String hasAnyAuthority() {
        return "ok";
    }
}
