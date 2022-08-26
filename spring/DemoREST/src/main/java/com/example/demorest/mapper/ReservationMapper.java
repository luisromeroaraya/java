package com.example.demorest.mapper;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Reservation;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ReservationCreateForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;

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
                .childId(entity.getChild().getId())
                .tutorId(entity.getTutor().getId())
                .build();
    }

    public Reservation toEntity(ReservationCreateForm form) {
        if (form == null)
            return null;
        Reservation reservation = new Reservation();
        reservation.setTimeArrival(form.getTimeArrival());
        reservation.setTimeDeparture(form.getTimeDeparture());
        reservation.setCanceled(form.isCanceled());
        reservation.setReason(form.getReason());
        reservation.setChild(childRepository.findById(form.getChildId()).orElseThrow(() -> new ElementNotFoundException(Child.class, form.getChildId())));
        reservation.setTutor(tutorRepository.findById(form.getTutorId()).orElseThrow(() -> new ElementNotFoundException(Tutor.class, form.getTutorId())));
        return reservation;
    }
}
