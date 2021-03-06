package com.example.demorest.mapper;

import com.example.demorest.model.dto.TutorDTO;
import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.model.forms.TutorAddForm;
import com.example.demorest.model.forms.TutorUpdateForm;
import com.example.demorest.service.ChildService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TutorMapper {
    public TutorDTO toDTO(Tutor entity) {
        if (entity == null)
           return null;
        return TutorDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .telephone(entity.getTelephone())
                .address(entity.getAddress())
                .childrenId(entity.getChildren().stream().map(Child::getId).collect(Collectors.toSet()))
                .build();
    }

    public Tutor toEntity(TutorAddForm form) {
        if (form == null)
            return null;
        Tutor tutor = new Tutor();
        tutor.setFirstName(form.getFirstName());
        tutor.setLastName(form.getLastName());
        tutor.setTelephone(form.getTelephone());
        tutor.setAddress(form.getAddress());
        return tutor;
    }

    public Tutor toEntity(TutorUpdateForm form) {
        if (form == null)
            return null;
        Tutor tutor = new Tutor();
        tutor.setFirstName(form.getFirstName());
        tutor.setLastName(form.getLastName());
        tutor.setTelephone(form.getTelephone());
        tutor.setAddress(form.getAddress());
//        tutor.setChildren(form.getChildrenId().stream()
//                .map(ChildService::getOne)
//                .collect(Collectors.toSet()));
        return tutor;
    }
}
