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
public class ChildAddForm {
    @NotBlank
    @Size(max = 255)
    private String firstName;
    @NotBlank
    @Size(max = 255)
    private String lastName;
    @NotNull
    @PastOrPresent // can't be a future date
    private LocalDate birthDate;
    private boolean toilet;
    @NotNull
    @Size(max = 10)
    private List<String> allergies;
    private Set<Long> tutorsId = new HashSet<>();
}
