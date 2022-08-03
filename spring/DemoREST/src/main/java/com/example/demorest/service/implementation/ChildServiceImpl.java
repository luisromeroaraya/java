package com.example.demorest.service.implementation;

import com.example.demorest.model.entities.Child;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.service.ChildService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository repository;

    public ChildServiceImpl(ChildRepository repository) {
        this.repository = repository;
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
    public Child create(Child child) {
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        child.setId(0L);
        return repository.save(child);
    }

    @Override
    public Child update(Long id, Child child) {
        if(id == null)
            throw new IllegalArgumentException("Id can't be null.");
        if(child == null)
            throw new IllegalArgumentException("Child can't be null.");
        if(!repository.existsById(id))
            throw new EntityNotFoundException("Id not found.");
        child.setId(id);
        return repository.save(child);
    }

    @Override
    public Child delete(Long id) {
        Child child = getOne(id);
        repository.delete(child);
        return child;
    }

    public Set<Child> getAllById(Set<Long> ids){
        Set<Child> children = new HashSet<>(repository.findAllById(ids));
        return children;
    }
}