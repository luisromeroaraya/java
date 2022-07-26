package com.example.demospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class FirstController {
    List<String> names = Arrays.asList("Toto", "Tata", "Titi");

    @RequestMapping(path = "/first", method = RequestMethod.GET)
    public ModelAndView firstCall() {
        ModelAndView mv = new ModelAndView("first");
        String message = "SpringBoot";
        mv.addObject("message", message);
        mv.addObject("names", names);
        return mv;
    }

}
