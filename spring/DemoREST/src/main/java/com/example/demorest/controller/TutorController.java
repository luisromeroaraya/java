package com.example.demorest.controller;

import com.example.demorest.mapper.TutorMapper;
import com.example.demorest.model.dto.TutorDTO;
import com.example.demorest.model.forms.TutorAddForm;
import com.example.demorest.model.forms.TutorUpdateForm;
import com.example.demorest.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {
    private final TutorService service;
    private final TutorMapper mapper;

    public TutorController(TutorService service, TutorMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id:[0-9]+}")
    public TutorDTO getOne(@PathVariable Long id) {
        return mapper.toDTO(service.getOne(id));
    }

    @GetMapping("")
    public List<TutorDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @PostMapping ("/add")
    public TutorDTO save(@RequestBody TutorAddForm form) {
        return mapper.toDTO(service.create(mapper.toEntity(form)));
    }

    @PutMapping("/update/{id}")
    public TutorDTO update(@PathVariable Long id, @RequestBody TutorUpdateForm form) {
        return mapper.toDTO(service.update(id, mapper.toEntity(form)));
    }

    @DeleteMapping("/delete/{id}")
    public TutorDTO delete(@PathVariable Long id) {
        return mapper.toDTO(service.delete(id));
    }
}
