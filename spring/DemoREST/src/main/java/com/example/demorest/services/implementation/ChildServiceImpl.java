package com.example.demorest.services.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.ElementsNotFoundException;
import com.example.demorest.mapper.ChildMapper;
import com.example.demorest.mapper.ReservationMapper;
import com.example.demorest.models.dto.ChildDTO;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Reservation;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.ChildUpdateForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.ReservationRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.services.ChildService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;
    private final ReservationRepository reservationRepository;
    private final ChildMapper childMapper;
    private final ReservationMapper reservationMapper;

    public ChildServiceImpl(ChildRepository childRepository, TutorRepository tutorRepository, ReservationRepository reservationRepository, ChildMapper childMapper, ReservationMapper reservationMapper) {
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
        this.reservationRepository = reservationRepository;
        this.childMapper = childMapper;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ChildDTO getOne(Long id) {
        return childRepository.findById(id)
                .map(childMapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, id));
    }

    @Override
    public List<ChildDTO> getAll() {
        return childRepository.findAll().stream()
                .map(childMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChildDTO create(ChildAddForm childAddForm) {
        Child child = childMapper.toEntity(childAddForm);
        Set<Long> tutorsId = childAddForm.getTutorsId();

        // check if every tutorsId exist
        Set<Tutor> tutors = new HashSet<>(tutorRepository.findAllById(tutorsId));
        if(tutors.size() < tutorsId.size() ){
            Set<Long> found = tutors.stream()
                    .map(Tutor::getId)
                    .collect(Collectors.toSet());
            Set<Long> notFound = tutorsId.stream()
                    .filter( tutorId -> !found.contains(tutorId) )
                    .collect(Collectors.toSet());
            throw new ElementsNotFoundException(Tutor.class, notFound);
        }

        child.setTutors(tutors);
        child = childRepository.save(child);
        return childMapper.toDTO(child);
    }

    @Override
    public ChildDTO update(@NotNull Long id, ChildUpdateForm childUpdateForm) {
        if (!childRepository.existsById(id))
            throw new ElementNotFoundException(Child.class, id);
        Child child = childMapper.toEntity(childUpdateForm);
        child.setId(id);
        Set<Long> tutorsId = childUpdateForm.getTutorsId();

        // check if every tutorsId exist
        Set<Tutor> tutors = new HashSet<>(tutorRepository.findAllById(tutorsId));
        if(tutors.size() < tutorsId.size() ){
            Set<Long> found = tutors.stream()
                    .map(Tutor::getId)
                    .collect(Collectors.toSet());
            Set<Long> notFound = tutorsId.stream()
                    .filter( tutorId -> !found.contains(tutorId) )
                    .collect(Collectors.toSet());
            throw new ElementsNotFoundException(Tutor.class, notFound);
        }

        child.setTutors(tutors);
        child = childRepository.save(child);
        return childMapper.toDTO(child);
    }

    @Override
    public ChildDTO delete(Long id) {
        Child child = childRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, id));
        ChildDTO childDTO = childMapper.toDTO(child);
        childRepository.delete(child);
        return childDTO;
    }

    @Override
    public ChildDTO removeTutor(Long childId, Long tutorId) {
        if (childId == null || tutorId == null)
            throw new IllegalArgumentException("Id can't be null");
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, childId));
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new ElementNotFoundException(Tutor.class, tutorId));
        Set<Tutor> tutors = child.getTutors();
        tutors.remove(tutor);
        child.setTutors(tutors);
        child = childRepository.save(child);
        return childMapper.toDTO(child);
    }

    @Override
    public ChildDTO updateTutors(Long id, Set<Long> tutorsId) {
        Child child = childRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Child.class, id));

        // check if every tutorsId exist
        Set<Tutor> tutors = new HashSet<>(tutorRepository.findAllById(tutorsId));
        if(tutors.size() < tutorsId.size() ){
            Set<Long> found = tutors.stream()
                    .map(Tutor::getId)
                    .collect(Collectors.toSet());
            Set<Long> notFound = tutorsId.stream()
                    .filter( tutorId -> !found.contains(tutorId) )
                    .collect(Collectors.toSet());
            throw new ElementsNotFoundException(Tutor.class, notFound);
        }

        child.setTutors(tutors);
        child = childRepository.save(child);
        return childMapper.toDTO(child);
    }

    @Override
    public List<ChildDTO> getAllFromFirstName(String firstName) {
        return childRepository.findByFirstName(firstName).stream()
                .map(childMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChildDTO> getAllFromDate(LocalDate date) {
        return reservationRepository.findByTimeArrivalBetweenAndCanceledIsFalse(date.atStartOfDay(), date.plusDays(1).atStartOfDay()).stream()
                .map(Reservation::getChild)
                .map(childMapper::toDTO)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> getFutureReservations(Long childId) {
        return reservationRepository.findByChild_IdAndTimeArrivalAfterAndCanceledIsFalse(childId, LocalDateTime.now()).stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }
}