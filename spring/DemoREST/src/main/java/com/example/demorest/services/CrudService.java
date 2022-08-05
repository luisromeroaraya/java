package com.example.demorest.services;

import java.util.List;

public interface CrudService<TDTO, TID, TAFORM, TUFORM> {
    // READ
    TDTO getOne(TID id);
    List<TDTO> getAll();
    // CREATE
    TDTO create(TAFORM taform);
    // UPDATE
    TDTO update(TID id, TUFORM tuform);
    // DELETE
    TDTO delete(TID id);
}