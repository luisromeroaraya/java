package com.example.demorest.service;

import com.example.demorest.model.entities.Child;

import java.util.Set;

public interface ChildService extends CrudService<Child, Long> {
    Set<Child> getAllById(Set<Long> ids);
}
