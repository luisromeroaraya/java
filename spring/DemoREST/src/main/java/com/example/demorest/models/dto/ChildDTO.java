package com.example.demorest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class ChildDTO {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String toilet;
    private List<String> allergies;
    private Set<Long> tutorsId;
}
