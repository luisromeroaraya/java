package com.example.demorest.service.implementation;

import com.example.demorest.model.entities.Tutor;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.service.TutorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TutorServiceImpl implements TutorService {
    private final TutorRepository repository;

    public TutorServiceImpl(TutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tutor getOne(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Tutor> getAll() {
        return repository.findAll();
    }

    @Override
    public Tutor create(Tutor tutor) {
        if(tutor == null)
            throw new IllegalArgumentException("Tutor can't be null.");
        tutor.setId(0L);
        return repository.save(tutor);
    }

    @Override
    public Tutor update(Long id, Tutor tutor) {
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(tutor == null)
            throw new IllegalArgumentException("Tutor can't be null.");
        if(!repository.existsById(id))
            throw new EntityNotFoundException("Id not found.");
        tutor.setId(id);
        return repository.save(tutor);
    }

    @Override
    public Tutor delete(Long id) {
        Tutor tutor = getOne(id);
        repository.delete(tutor);
        return tutor;
    }

    public Set<Tutor> getAllById(Set<Long> ids){
        Set<Tutor> tutors = new HashSet<>(repository.findAllById(ids));
        return tutors;
    }
}
