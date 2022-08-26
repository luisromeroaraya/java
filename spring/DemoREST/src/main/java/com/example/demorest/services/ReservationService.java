package com.example.demorest.services;

import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ReservationCreateForm;
import com.example.demorest.models.forms.ReservationCancelForm;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService extends CrudService<ReservationDTO, Long, ReservationCreateForm, ReservationCancelForm> {
    List<ReservationDTO> getReservationsForDate(LocalDate date);
    Long getNumberOfReservationsLeftForThisMonth();
    boolean checkDate(LocalDate date);
}
