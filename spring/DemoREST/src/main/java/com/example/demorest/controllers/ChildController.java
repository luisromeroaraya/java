package com.example.demorest.controllers;

import com.example.demorest.mapper.ChildMapper;
import com.example.demorest.models.dto.ChildDTO;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.ChildUpdateForm;
import com.example.demorest.services.ChildService;
import com.example.demorest.services.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/children")
public class ChildController {
    private final ChildService childService;
    private final TutorService tutorService;
    private final ChildMapper childMapper;

    public ChildController(ChildService childService, TutorService tutorService, ChildMapper childMapper) {
        this.childService = childService;
        this.tutorService = tutorService;
        this.childMapper = childMapper;
    }

    @GetMapping("/{id:[0-9]+}")
    public ChildDTO getOne(@PathVariable Long id) {
        return childService.getOne(id);
    }

    @GetMapping("")
    public List<ChildDTO> getAll() {
        return childService.getAll();
    }

    @PostMapping ("/add")
    public ChildDTO save(@RequestBody ChildAddForm childAddForm) {
        return childService.create(childAddForm);
    }

    @PutMapping("/update/{id}") // PUT updates every attribute, PATCH updates ony the specified attributes
    public ChildDTO update(@PathVariable Long id, @RequestBody ChildUpdateForm childUpdateForm) {
        return childService.update(id, childUpdateForm);
    }

    @DeleteMapping("/delete/{id}")
    public ChildDTO delete(@PathVariable Long id) {
        return childService.delete(id);
    }

    @PatchMapping("/updateTutors/{id}")
    public ChildDTO updateTutors(@PathVariable Long id, @RequestBody ChildUpdateForm childUpdateForm) {
        return childService.updateTutors(id, childUpdateForm.getTutorsId());
    }

}
