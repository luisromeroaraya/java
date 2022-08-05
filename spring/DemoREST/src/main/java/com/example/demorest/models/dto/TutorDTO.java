package com.example.demorest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TutorDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private Set<Long> childrenId;
}
