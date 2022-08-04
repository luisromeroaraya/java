package com.example.demorest.service;

import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;

import java.util.Set;

public interface ChildService extends CrudService<Child, Long> {
    Set<Child> getAllById(Set<Long> ids);
    void removeTutor(Long childId, Long tutorId);
    Child updateTutors(Long childId, Set<Tutor> tutors);
}
