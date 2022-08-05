package com.example.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class TutorAddForm {
    @NotBlank
    @Size(max = 255)
    private String firstName;
    @NotBlank
    @Size(max = 255)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "\\d{9}")
    private String telephone;
    @NotBlank
    private String address;
    private Set<Long> childrenId = new HashSet<>();
}
