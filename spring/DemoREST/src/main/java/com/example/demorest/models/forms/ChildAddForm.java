package com.example.demorest.models.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ChildAddForm {
    @NotBlank
    // @NotNull for every type of object
    @Size(max = 255)
    private String firstName;
    @NotBlank
    @Size(max = 255)
    private String lastName;
    @PastOrPresent // can't be a future date
    private LocalDate birthDate;
    private boolean toilet;
    @Size(max = 10)
    private List<String> allergies;
    private Set<Long> tutorsId = new HashSet<>();
}
