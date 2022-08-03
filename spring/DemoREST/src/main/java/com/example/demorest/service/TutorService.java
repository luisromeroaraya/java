package com.example.demorest.service;

import com.example.demorest.model.entities.Tutor;

import java.util.Set;

public interface TutorService extends CrudService<Tutor, Long> {
    Set<Tutor> getAllById(Set<Long> ids);
}
