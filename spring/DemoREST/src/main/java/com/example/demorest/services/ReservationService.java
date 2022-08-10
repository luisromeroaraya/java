package com.example.demorest.services;

import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.models.forms.ReservationCancelForm;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService extends CrudService<ReservationDTO, Long, ReservationAddForm, ReservationCancelForm> {
    List<ReservationDTO> getReservationsForDate(LocalDate date);
    List<ReservationDTO> getReservationsLeftForThisMonth();
}
