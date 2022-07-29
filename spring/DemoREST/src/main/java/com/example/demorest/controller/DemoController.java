package com.example.demorest.controller;

import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    // GET - http://localhost:8080/person
    @GetMapping("/person")
    @ResponseBody
    @ResponseStatus(HttpStatus.IM_USED)
    public void getPerson(){
        System.out.println("hello");
    }

    // POST - http://localhost:8080/person
    @PostMapping("/person")
    public void writePerson(@RequestBody Person person, @RequestParam("repetition") int iter) {
        for (int i=0; i < iter; i++) {
            System.out.println(person);
        }
    }

//    // GET - http://localhost:8080/params
//    @GetMapping("/params")
//    public void writeParams(@RequestParam Map<String, Object> params) {
//        for(String key : params.keySet()) {
//            System.out.println(key + " - " + params.get(key));
//        }
//    }
//
//    // GET - http://localhost:8080/headers
//    @GetMapping("/headers")
//    public void writeArtificialHeader(@RequestHeader String artificial) { // the name of the header is automatically detected if you write it here
//        System.out.println(artificial);
//    }
//
//    // GET - http://localhost:8080/headers/all
//    @GetMapping("headers/all")
//    public void writeAllHeaders(@RequestHeader HttpHeaders headers) {
//        for(String key : headers.keySet()) {
//            System.out.println(key + " - " + headers.get(key));
//        }
//    }
//
//    // GET - http://localhost:8080/demo/{id}
//    @GetMapping("/demo/{id:[0-8]{0,3}}") // we can use regex to forbid characters in the url https://regex101.com/
//    public void demoPathVar(@PathVariable("id") int id) {
//        System.out.println("The id is: " + id);
//    }
//
//    @GetMapping("/request")
//    public void getRequest(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(request);
//        System.out.println(response);
//    }
//
//    @GetMapping("/person/new")
//    public ResponseEntity<Person> getPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
//        Child body = new Child(firstName, lastName, LocalDate.now(), false, List.of("None"));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("artificial", "my value");
//
//        HttpStatus status = HttpStatus.OK;
//
//        // return new ResponseEntity<>(body, headers, status); // this is another way of returning
//        return ResponseEntity
//                .status(status)
//                .header("blabla", "1")
//                .headers(headers)
//                .body(body);
//    }
}
