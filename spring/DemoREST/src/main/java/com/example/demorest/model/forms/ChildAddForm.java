package com.example.demorest.model.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChildAddForm {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean toilet;
}
