package com.example.demorest.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TutorDTO {
    private long id;
    private Set<ChildDTO> children;
}
