package com.example.demorest.services;

import com.example.demorest.models.dto.ChildDTO;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.entities.Reservation;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.ChildUpdateForm;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ChildService extends CrudService<ChildDTO, Long, ChildAddForm, ChildUpdateForm> {
    ChildDTO removeTutor(Long childId, Long tutorId);
    ChildDTO updateTutors(Long childId, Set<Long> tutorsId);
    List<ChildDTO> getAllFromFirstName(String firstName);
    List<ChildDTO> getAllFromDate(LocalDate date);
    List<ReservationDTO> getFutureReservations(Long childId);
}
