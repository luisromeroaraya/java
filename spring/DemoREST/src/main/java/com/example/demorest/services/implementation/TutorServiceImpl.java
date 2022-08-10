package com.example.demorest.services.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.NullElementException;
import com.example.demorest.mapper.TutorMapper;
import com.example.demorest.models.dto.TutorDTO;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.TutorAddForm;
import com.example.demorest.models.forms.TutorUpdateForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.services.ChildService;
import com.example.demorest.services.TutorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorService {
    private final TutorRepository tutorRepository;
    private final ChildRepository childRepository;
    private final ChildService childService;
    private final TutorMapper tutorMapper;

    public TutorServiceImpl(TutorRepository tutorRepository, ChildRepository childRepository, ChildService childService, TutorMapper tutorMapper) {
        this.tutorRepository = tutorRepository;
        this.childRepository = childRepository;
        this.childService = childService;
        this.tutorMapper = tutorMapper;
    }

    @Override
    public TutorDTO getOne(Long id) {
        return tutorRepository.findById(id)
                .map(tutorMapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(Tutor.class, id));
    }

    @Override
    public List<TutorDTO> getAll() {
        return tutorRepository.findAll().stream()
                .map(tutorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TutorDTO create(TutorAddForm tutorAddForm) {
        if(tutorAddForm == null)
            throw new NullElementException(Tutor.class);
        Tutor tutor = tutorMapper.toEntity(tutorAddForm);
        Set<Child> children = new HashSet<>(childRepository.findAllById(tutorAddForm.getChildrenId())); // Tutors can't declare their children because they are the weak Entity
        tutor.setChildren(children);
        tutor = tutorRepository.save(tutor);
        return tutorMapper.toDTO(tutor);
    }

    @Override
    public TutorDTO update(Long id, TutorUpdateForm tutorUpdateForm) {
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(tutorUpdateForm == null)
            throw new NullElementException(Tutor.class);
        if(!tutorRepository.existsById(id))
            throw new ElementNotFoundException(Tutor.class, id);
        Tutor tutor = tutorMapper.toEntity(tutorUpdateForm);
        tutor.setId(id);
        Set<Child> children = new HashSet<>(childRepository.findAllById(tutorUpdateForm.getChildrenId())); // Tutors can't update their children because they are the weak Entity
        tutor.setChildren(children);
        tutor = tutorRepository.save(tutor);
        return tutorMapper.toDTO(tutor);
    }

    @Override
    public TutorDTO delete(Long tutorId) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(()-> new ElementNotFoundException(Tutor.class, tutorId));
        Set<Child> children = tutor.getChildren();
        if(children.size() > 0)
            children.forEach(child -> childService.removeTutor(child.getId(), tutorId));
        TutorDTO tutorDTO = tutorMapper.toDTO(tutor);
        tutorRepository.delete(tutor);
        return tutorDTO;
    }

    @Override
    public List<TutorDTO> getAllFromCity(String city) {
        return tutorRepository.findAllByAddress_CityContains(city).stream()
                .map(tutorMapper::toDTO).
                collect(Collectors.toList());
    }
}