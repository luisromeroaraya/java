package com.metaltravelguide.places.services;

import com.metaltravelguide.places.models.dtos.PlaceDTO;
import com.metaltravelguide.places.models.forms.PlaceAddForm;
import com.metaltravelguide.places.models.forms.PlaceUpdateForm;

public interface PlaceService extends CrudService<PlaceDTO, Long, PlaceAddForm, PlaceUpdateForm> {
}
