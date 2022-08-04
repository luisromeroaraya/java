package com.example.demorest.controller;

import com.example.demorest.mapper.TutorMapper;
import com.example.demorest.model.dto.TutorDTO;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.model.forms.TutorAddForm;
import com.example.demorest.model.forms.TutorUpdateForm;
import com.example.demorest.service.ChildService;
import com.example.demorest.service.TutorService;
import org.springframework.web.bind.annotation.*;

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
        // we get the entity from the DB
        Tutor tutor = tutorService.getOne(id);
        // we convert it into a DTO
        TutorDTO tutorDTO = tutorMapper.toDTO(tutor);
        // we return our new tutorDTO with the childrenId that we injected
        return tutorDTO;
    }

    @GetMapping("")
    public List<TutorDTO> getAll() {
        // we get the list of entities from the DB
        List<Tutor> tutors = tutorService.getAll();
        // we create an empty list of DTOs
        List<TutorDTO> tutorsDTO = new ArrayList<>();
        // if the children list is not empty we put all the childrenDTOs into the DTO list
        if (tutors.size() > 0) {
            tutorsDTO = tutorService.getAll().stream()
                    .map(tutorMapper::toDTO)
                    .toList();
        }
        // we return the DTO list
        return tutorsDTO;
    }

    @PostMapping ("/add")
    public TutorDTO save(@RequestBody TutorAddForm form) {
        Tutor tutor = tutorMapper.toEntity(form);
        Set<Child> children = childService.getAllById(form.getChildrenId()); // Tutors can't declare their children because they are the weak Entity
        tutor.setChildren(children);
        TutorDTO tutorDTO = tutorMapper.toDTO(tutorService.create(tutor));
        return tutorDTO;
    }

    @PutMapping("/update/{id}") // PUT updates every attribute, PATCH updates ony the specified attributes
    public TutorDTO update(@PathVariable Long id, @RequestBody TutorUpdateForm form) {
        Tutor tutor = tutorMapper.toEntity(form);
        Set<Child> children = childService.getAllById(form.getChildrenId()); // Tutors can't update their children because they are the weak Entity
        tutor.setChildren(children);
        TutorDTO tutorDTO = tutorMapper.toDTO(tutorService.update(id, tutor));
        return tutorDTO;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        tutorService.delete(id);
    }
}
