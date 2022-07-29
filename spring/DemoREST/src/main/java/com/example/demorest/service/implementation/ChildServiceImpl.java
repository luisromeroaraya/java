package com.example.demorest.service.implementation;

import com.example.demorest.model.entities.Child;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.service.ChildService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository repository;

    public ChildServiceImpl(ChildRepository repository) {
        this.repository = repository;
    }

    @Override
    public Child save(Child child) {
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        return repository.save(child);
    }

    @Override
    public Child getOne(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Child> getAll() {
        return repository.findAll();
    }

    @Override
    public Child delete(Long id) {
        Child child = getOne(id);
        repository.delete(child);
        return child;
    }
}
