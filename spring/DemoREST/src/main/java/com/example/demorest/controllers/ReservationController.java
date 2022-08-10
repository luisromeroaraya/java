package com.example.demorest.controllers;

import com.example.demorest.mapper.ReservationMapper;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.models.forms.ReservationCancelForm;
import com.example.demorest.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;
    private ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping("/{id:[0-9]+}")
    public ReservationDTO getOne(@PathVariable Long id) {
        return reservationService.getOne(id);
    }

    @GetMapping("")
    public List<ReservationDTO> getAll() {
        return reservationService.getAll();
    }

    @PostMapping("/add")
    public ReservationDTO save(@Valid @RequestBody ReservationAddForm reservationAddForm) {
        return reservationService.create(reservationAddForm);
    }

    @PatchMapping("/cancel/{id}")
    public ReservationDTO cancel(@PathVariable Long id, @Valid @RequestBody ReservationCancelForm reservationCancelForm) {
        return reservationService.update(id, reservationCancelForm);
    }

    @GetMapping("/left-this-month")
    public List<ReservationDTO> getReservationsLeftForThisMonth() {
        return reservationService.getReservationsLeftForThisMonth();
    }
}
