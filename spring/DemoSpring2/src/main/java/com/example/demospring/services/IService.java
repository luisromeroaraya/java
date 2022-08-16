package com.example.demospring.services;

import java.util.List;

public interface IService<T, TDTO, TID> {
    List<TDTO> getAll();
    TDTO getById(TID id);
    boolean update(TID id, T entity);
    boolean delete(TID id);
    TDTO insert(T entity);
}
