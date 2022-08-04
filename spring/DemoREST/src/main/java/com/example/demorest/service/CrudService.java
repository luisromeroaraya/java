package com.example.demorest.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudService<T, TID> {
//    List<TDTO> getAll();
//    TDTO getById(TID id);
//    boolean update(TID id, T entity);
//    boolean delete(TID id);
//    TDTO insert(T entity);

    // READ
    T getOne(TID id);
    List<T> getAll();
    // CREATE
    T create(T toInsert);
    // UPDATE
    T update(TID id, T toUpdate);
    // DELETE
    void delete(TID id);
}