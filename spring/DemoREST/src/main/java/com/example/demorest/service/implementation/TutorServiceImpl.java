package com.example.demorest.service.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.ElementsNotFoundException;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.service.ChildService;
import com.example.demorest.service.TutorService;
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

    public TutorServiceImpl(TutorRepository tutorRepository, ChildRepository childRepository, ChildService childService) {
        this.tutorRepository = tutorRepository;
        this.childRepository = childRepository;
        this.childService = childService;
    }

    @Override
    public Tutor getOne(Long id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Tutor.class, id));
    }

    @Override
    public List<Tutor> getAll() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor create(Tutor tutor) {
        if(tutor == null)
            throw new IllegalArgumentException("Tutor can't be null.");
        tutor.setId(null);
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor update(Long id, Tutor tutor) {
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(tutor == null)
            throw new IllegalArgumentException("Tutor can't be null.");
        if(!tutorRepository.existsById(id))
            throw new ElementNotFoundException(Tutor.class, id);
        tutor.setId(id);
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor delete(Long tutorId) {
        if( tutorId == null )
            throw new IllegalArgumentException("Id can't be null.");
        if( !tutorRepository.existsById(tutorId) )
            throw new ElementNotFoundException(Tutor.class, tutorId);
        Tutor tutor = getOne(tutorId);
        Set<Child> children = tutor.getChildren();
        if(children.size() > 0) {
            for (Child child : children) {
                childService.removeTutor(child.getId(), tutorId);
            }
        }
        tutorRepository.delete(tutor);
        return tutor;
    }

    public Set<Tutor> getAllById(Set<Long> ids){
        // I try to find all the tutors with the ids given
        Set<Tutor> tutors = new HashSet<>(tutorRepository.findAllById(ids));
        // I create a Set<Long> of all the ids I actually found
        Set<Long> found = tutors.stream()
                .map(Tutor::getId)
                .collect(Collectors.toSet());
        // I filter the ids that were not found (ids that don't exist in the db)
        Set<Long> notFound = ids.stream()
                .filter(id -> !found.contains(id))
                .collect(Collectors.toSet());
        // if I have ids that were not found I send an exception with the list of them
        if(notFound.size() > 0)
            throw new ElementsNotFoundException(Tutor.class, notFound);
        return tutors;
    }
}
