package com.example.demorest.controller;

import com.example.demorest.mapper.ChildMapper;
import com.example.demorest.model.dto.ChildDTO;
import com.example.demorest.model.forms.ChildAddForm;
import com.example.demorest.model.forms.ChildUpdateForm;
import com.example.demorest.service.ChildService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/children")
public class ChildController {
    private final ChildService service;
    private final ChildMapper mapper;

    public ChildController(ChildService service, ChildMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id:[0-9]+}")
    public ChildDTO getOne(@PathVariable Long id) {
        return mapper.toDTO(service.getOne(id));
    }

    @GetMapping("")
    public List<ChildDTO> getAll() {
        return service.getAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @PostMapping ("/add")
    public ChildDTO save(@RequestBody ChildAddForm form) {
        return mapper.toDTO(service.create(mapper.toEntity(form)));
    }

    @PutMapping("/update/{id}")
    public ChildDTO update(@PathVariable Long id, @RequestBody ChildUpdateForm form) {
        return mapper.toDTO(service.update(id, mapper.toEntity(form)));
    }

    @DeleteMapping("/delete/{id}")
    public ChildDTO delete(@PathVariable Long id) {
        return mapper.toDTO(service.delete(id));
    }
}
