package com.example.demorest.service.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.service.ChildService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;

    public ChildServiceImpl(ChildRepository childRepository, TutorRepository tutorRepository) {
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Child getOne(Long id) {
        return childRepository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Child.class, id) );
    }

    @Override
    public List<Child> getAll() {
        return childRepository.findAll();
    }

    @Override
    public Child create(Child child) {
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        child.setId(null);
        return childRepository.save(child);
    }

    @Override
    public Child update(Long id, Child child) {
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        if(!childRepository.existsById(id))
            throw new ElementNotFoundException(Child.class, id);
        child.setId(id);
        return childRepository.save(child);
    }

    @Override
    public void delete(Long id) {
        if( id == null )
            throw new IllegalArgumentException("Id can't be null");
        if( !childRepository.existsById(id) )
            throw new ElementNotFoundException(Child.class, id);
        Child child = getOne(id);
        childRepository.delete(child);
    }

    public void removeTutor(Long childId, Long tutorId) {
        if( childId == null || tutorId == null )
            throw new IllegalArgumentException("Id can't be null");
        if( !childRepository.existsById(childId))
            throw new ElementNotFoundException(Child.class, childId);
        if( !tutorRepository.existsById(tutorId))
            throw new ElementNotFoundException(Tutor.class, tutorId);
        Child child = getOne(childId);
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new ElementNotFoundException(Tutor.class, tutorId));
        Set<Tutor> tutors = child.getTutors();
        tutors.remove(tutor);
        child.setTutors(tutors);
        update(childId, child);
    }

    public Child updateTutors(Long id, Set<Tutor> tutors) {
        Child child = getOne(id);
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        if(!childRepository.existsById(id))
            throw new ElementNotFoundException(Child.class, id);
        child.setId(id);
        child.setTutors(tutors);
        return childRepository.save(child);
    }

    public Set<Child> getAllById(Set<Long> ids) {
        Set<Child> children = new HashSet<>(childRepository.findAllById(ids));
        return children;
    }
}