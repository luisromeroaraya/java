package com.example.demorest.services;

import com.example.demorest.models.dto.TutorDTO;
import com.example.demorest.models.forms.TutorAddForm;
import com.example.demorest.models.forms.TutorUpdateForm;

public interface TutorService extends CrudService<TutorDTO, Long, TutorAddForm, TutorUpdateForm> {
}
