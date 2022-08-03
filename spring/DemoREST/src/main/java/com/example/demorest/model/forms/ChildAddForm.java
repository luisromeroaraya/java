package com.example.demorest.model.forms;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class ChildAddForm {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean toilet;
    private List<String> allergies;
    private Set<Long> tutorsId;
}
