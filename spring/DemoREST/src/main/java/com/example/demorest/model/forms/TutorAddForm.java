package com.example.demorest.model.forms;

import lombok.Data;

import java.util.Set;

@Data
public class TutorAddForm {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private Set<Long> childrenId;
}
