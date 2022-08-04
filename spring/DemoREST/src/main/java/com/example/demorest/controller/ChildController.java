package com.example.demorest.controller;

import com.example.demorest.mapper.ChildMapper;
import com.example.demorest.model.dto.ChildDTO;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.model.forms.ChildAddForm;
import com.example.demorest.model.forms.ChildUpdateForm;
import com.example.demorest.service.ChildService;
import com.example.demorest.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        // we get the entity from the DB
        Child child = childService.getOne(id);
        // we convert it into a DTO
        ChildDTO childDTO = childMapper.toDTO(child);
        // we return our new childDTO with the tutorsId that we injected
        return childDTO;
    }

    @GetMapping("")
    public List<ChildDTO> getAll() {
        // we get the list of entities from the DB
        List<Child> children = childService.getAll();
        // we create an empty list of DTOs
        List<ChildDTO> childrenDTO = new ArrayList<>();
        // if the children list is not empty we put all the childrenDTOs into the DTO list
        if (children.size() > 0) {
            childrenDTO = childService.getAll().stream()
                    .map(childMapper::toDTO)
                    .toList();
        }
        // we return the DTO list
        return childrenDTO;
    }

    @PostMapping ("/add")
    public ChildDTO save(@RequestBody ChildAddForm form) {
        Child child = childMapper.toEntity(form);
        Set<Tutor> tutors = tutorService.getAllById(form.getTutorsId());
        child.setTutors(tutors);
        ChildDTO childDTO = childMapper.toDTO(childService.create(child));
        return childDTO;
    }

    @PutMapping("/update/{id}") // PUT updates every attribute, PATCH updates ony the specified attributes
    public ChildDTO update(@PathVariable Long id, @RequestBody ChildUpdateForm form) {
        Child child = childMapper.toEntity(form);
        Set<Tutor> tutors = tutorService.getAllById(form.getTutorsId());
        child.setTutors(tutors);
        ChildDTO childDTO = childMapper.toDTO(childService.update(id, child));
        return childDTO;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        childService.delete(id);
    }

//    @PatchMapping("/updateTutors/{id}")
//    public ChildDTO updateTutors(@PathVariable Long id, @RequestBody ChildUpdateForm form) {
//        Child child = childService.getOne(id);
//        Set<Tutor> tutors = tutorService.getAllById(form.getTutorsId());
//        child.setTutors(tutors);
//        ChildDTO childDTO = childMapper.toDTO(childService.update(id, child));
//        return childDTO;
//    }

    @PatchMapping("/updateTutors/{id}")
    public ChildDTO updateTutors(@PathVariable Long id, @RequestBody ChildUpdateForm form) {
        Set<Tutor> tutors = tutorService.getAllById(form.getTutorsId());
        ChildDTO childDTO = childMapper.toDTO(childService.updateTutors(id, tutors));
        return childDTO;
    }

}
