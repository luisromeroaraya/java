package com.example.demorest.mapper;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Reservation;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private ChildRepository childRepository;
    private TutorRepository tutorRepository;

    public ReservationMapper(ChildRepository childRepository, TutorRepository tutorRepository) {
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
    }

    public ReservationDTO toDTO(Reservation entity) {
        if (entity == null)
            return null;
        return ReservationDTO.builder()
                .id(entity.getId())
                .timeArrival(entity.getTimeArrival())
                .timeDeparture(entity.getTimeDeparture())
                .canceled(entity.isCanceled() ? "Yes" : "No")
                .reason(entity.getReason())
                .child_id(entity.getChild().getId())
                .tutor_id(entity.getTutor().getId())
                .build();
    }

    public Reservation toEntity(ReservationAddForm form) {
        if (form == null)
            return null;
        Reservation reservation = new Reservation();
        reservation.setTimeArrival(form.getTimeArrival());
        reservation.setTimeDeparture(form.getTimeDeparture());
        reservation.setCanceled(form.isCanceled());
        reservation.setReason(form.getReason());
        reservation.setChild(childRepository.findById(form.getChild_id()).orElseThrow(() -> new ElementNotFoundException(Child.class, form.getChild_id())));
        reservation.setTutor(tutorRepository.findById(form.getTutor_id()).orElseThrow(() -> new ElementNotFoundException(Tutor.class, form.getTutor_id())));
        return reservation;
    }
}
