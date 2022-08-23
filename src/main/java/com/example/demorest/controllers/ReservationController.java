package com.example.demorest.controllers;

import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.models.forms.ReservationCancelForm;
import com.example.demorest.services.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
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
    public Long getNumberOfReservationsLeftForThisMonth() {
        return reservationService.getNumberOfReservationsLeftForThisMonth();
    }

    @GetMapping("/check-date")
    public boolean checkDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return reservationService.checkDate(date);
    }
}
