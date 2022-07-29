package com.example.demorest.mapper;

import com.example.demorest.model.dto.ChildDTO;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.forms.ChildAddForm;
import org.springframework.stereotype.Component;

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
                // .tutors()
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
}
