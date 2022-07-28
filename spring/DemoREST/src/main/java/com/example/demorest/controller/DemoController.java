package com.example.demorest.controller;

import com.example.demorest.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // GET - http://localhost:8080/person
    @GetMapping("/person")
    public Person getPerson(){
        return new Person("alex", "kim");
    }
}
