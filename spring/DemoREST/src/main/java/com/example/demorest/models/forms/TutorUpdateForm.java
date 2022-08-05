package com.example.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class TutorUpdateForm {
    @NotBlank
    @Size(max = 50)
    private String firstName;
    @NotBlank
    @Size(max = 50)
    private String lastName;
    private String telephone;
    private String address;
    private Set<Long> childrenId = new HashSet<>();
}
