package com.example.demospring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/api")
public class RestFirstController {
    @RequestMapping(path = "/first")
    String hello() {
        return "hello";
    }


}
