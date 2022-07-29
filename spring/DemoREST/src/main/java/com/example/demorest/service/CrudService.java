package com.example.demorest.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudService<T, TID> {
//    List<TDTO> getAll();
//    TDTO getById(TID id);
//    boolean update(TID id, T entity);
//    boolean delete(TID id);
//    TDTO insert(T entity);

    // CREATE / UPDATE
    T save(T T);
    // READ
    T getOne(TID id);
    List<T> getAll();
    // DELETE
    T delete(TID id);
}