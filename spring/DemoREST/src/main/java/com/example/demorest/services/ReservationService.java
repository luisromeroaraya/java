package com.example.demorest.services;

import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.models.forms.ReservationCancelForm;

public interface ReservationService extends CrudService<ReservationDTO, Long, ReservationAddForm, ReservationCancelForm> {
}
