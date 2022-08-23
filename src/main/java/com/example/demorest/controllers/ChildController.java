package com.example.demorest.controllers;

import com.example.demorest.models.dto.ChildDTO;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.ChildUpdateForm;
import com.example.demorest.services.ChildService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/children")
public class ChildController {
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
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
    public ChildDTO save(@Valid @RequestBody ChildAddForm childAddForm) {
        return childService.create(childAddForm);
    }

    @PutMapping("/update/{id}") // PUT updates every attribute, PATCH updates ony the specified attributes
    public ChildDTO update(@Valid @PathVariable Long id, @Valid @RequestBody ChildUpdateForm childUpdateForm) {
        return childService.update(id, childUpdateForm);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        childService.delete(id);
    }

    @PatchMapping("/updateTutors/{id}")
    public ChildDTO updateTutors(@Valid @PathVariable Long id, @RequestBody ChildUpdateForm childUpdateForm) {
        return childService.updateTutors(id, childUpdateForm.getTutorsId());
    }

    @GetMapping("/firstName/{firstName}")
    public List<ChildDTO> getAllFromFirstName(@PathVariable String firstName) {
        return childService.getAllFromFirstName(firstName);
    }

    @GetMapping("/date")
    public List<ChildDTO> getAllFromDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return childService.getAllFromDate(date);
    }

    @GetMapping("/{id:[0-9]+}/reservations")
    public List<ReservationDTO> getFutureReservations(@Valid @PathVariable Long id) {
        return childService.getFutureReservations(id);
    }
}
