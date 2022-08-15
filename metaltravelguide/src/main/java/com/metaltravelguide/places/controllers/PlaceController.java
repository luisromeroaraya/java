package com.metaltravelguide.places.controllers;

import com.metaltravelguide.places.models.dtos.PlaceDTO;
import com.metaltravelguide.places.models.forms.PlaceAddForm;
import com.metaltravelguide.places.models.forms.PlaceUpdateForm;
import com.metaltravelguide.places.services.PlaceService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/all")
    public List<PlaceDTO> getAll() {
        return placeService.getAll();
    }

    @GetMapping("/{id:[0-9]+}")
    public PlaceDTO getOne(@PathVariable Long id) {
        return placeService.getOne(id);
    }

    @PostMapping("/add")
    public PlaceDTO add(@Valid @RequestBody PlaceAddForm placeAddForm, Authentication auth) {
        placeAddForm.setUsername(auth.getName());
        return placeService.create(placeAddForm);
    }

    @PatchMapping("/update/{id:[0-9]+}")
    public PlaceDTO update(@Valid @PathVariable Long id, @Valid @RequestBody PlaceUpdateForm placeUpdateForm, Authentication authentication) {
        placeUpdateForm.setUsername(authentication.getName());
        return placeService.update(id, placeUpdateForm);
    }

    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@Valid @PathVariable Long id) {
        placeService.delete(id);
    }
}
