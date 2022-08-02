package com.example.demorest.mapper;

import com.example.demorest.model.dto.ChildDTO;
import com.example.demorest.model.dto.TutorDTO;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.model.forms.ChildAddForm;
import com.example.demorest.model.forms.ChildUpdateForm;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ChildMapper {
    public ChildDTO toDTO(Child entity) {
        if (entity == null)
           return null;
        return ChildDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .birthDate(entity.getBirthDate())
                .allergies(entity.getAllergies())
                .toilet(entity.isToilet() ? "Yes" : "No")
                .tutorsId(entity.getTutors()
                        .stream()
                        .map(Tutor::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Child toEntity(ChildAddForm form) {
        if (form == null)
            return null;
        Child child = new Child();
        child.setFirstName(form.getFirstName());
        child.setLastName(form.getLastName());
        child.setBirthDate(form.getBirthDate());
        child.setToilet(form.isToilet());
        return child;
    }

    public Child toEntity(ChildUpdateForm form) {
        if (form == null)
            return null;
        Child entity = new Child();
        entity.setFirstName(form.getFirstName());
        entity.setLastName(form.getLastName());
        entity.setBirthDate(form.getBirthDate());
        entity.setToilet(form.isToilet());
        entity.setAllergies(form.getAllergies());
        return entity;
    }
}
