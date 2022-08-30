package com.metaltravelguide.places.services;

import java.util.List;

public interface CrudService<TDTO, TID, TAFORM, TUFORM>{
    // READ
    TDTO getOne(TID id);
    List<TDTO> getAll();
    // CREATE
    TDTO create(TAFORM taform);
    // UPDATE
    TDTO update(TID id, TUFORM tuform);
    // DELETE
    void delete(TID id);
}
