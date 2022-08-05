package com.example.demorest.controllers;

import com.example.demorest.mapper.TutorMapper;
import com.example.demorest.models.dto.TutorDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.TutorAddForm;
import com.example.demorest.models.forms.TutorUpdateForm;
import com.example.demorest.services.ChildService;
import com.example.demorest.services.TutorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tutors")
public class TutorController {
    private final TutorService tutorService;
    private final ChildService childService;
    private final TutorMapper tutorMapper;

    public TutorController(TutorService tutorService, ChildService childService, TutorMapper tutorMapper) {
        this.tutorService = tutorService;
        this.childService = childService;
        this.tutorMapper = tutorMapper;
    }

    @GetMapping("/{id:[0-9]+}")
    public TutorDTO getOne(@PathVariable Long id) {
        return tutorService.getOne(id);
    }

    @GetMapping("")
    public List<TutorDTO> getAll() {
        return tutorService.getAll();
    }

    @PostMapping ("/add")
    public TutorDTO save(@Valid @RequestBody TutorAddForm tutorAddForm) {
        return tutorService.create(tutorAddForm);
    }

    @PutMapping("/update/{id}") // PUT updates every attribute, PATCH updates ony the specified attributes
    public TutorDTO update(@Valid @PathVariable Long id, @RequestBody TutorUpdateForm tutorUpdateForm) {
        return tutorService.update(id, tutorUpdateForm);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        tutorService.delete(id);
    }
}
