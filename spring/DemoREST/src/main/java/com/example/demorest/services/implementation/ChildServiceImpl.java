package com.example.demorest.services.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.ElementsNotFoundException;
import com.example.demorest.mapper.ChildMapper;
import com.example.demorest.models.dto.ChildDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.ChildUpdateForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.services.ChildService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;
    private final ChildMapper childMapper;

    public ChildServiceImpl(ChildRepository childRepository, TutorRepository tutorRepository, ChildMapper childMapper) {
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
        this.childMapper = childMapper;
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
        if (childAddForm == null)
            throw new IllegalArgumentException("Child can't be null.");
        Child child = childMapper.toEntity(childAddForm);

        Set<Long> tutorsId = childAddForm.getTutorsId();
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
    public ChildDTO update(Long id, ChildUpdateForm childUpdateForm) {
        if (id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if (childUpdateForm == null)
            throw new IllegalArgumentException("Child can't be null.");
        if (!childRepository.existsById(id))
            throw new ElementNotFoundException(Child.class, id);
        Child child = childMapper.toEntity(childUpdateForm);
        child.setId(id);

        Set<Long> tutorsId = childUpdateForm.getTutorsId();
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
}