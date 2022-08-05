package com.example.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ChildUpdateForm {
    @NotBlank
    @Size(max = 255)
    private String firstName;
    @NotBlank
    @Size(max = 255)
    private String lastName;
    @NotNull
    @PastOrPresent
    private LocalDate birthDate;
    @NotBlank
    private boolean toilet;
    @Size(max = 10)
    private List<String> allergies;
    @NotNull
    private Set<Long> tutorsId = new HashSet<>();
}
