package com.example.demorest.models.dto;

import com.example.demorest.models.entities.Address;
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
    private Address address;
    private Set<Long> childrenId;
}
