package com.example.demorest.models.forms;

import com.example.demorest.models.entities.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
public class TutorUpdateForm {
    @NotBlank
    @Size(max = 255)
    private String firstName;
    @NotBlank
    @Size(max = 255)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "0?[0-9]{3}-?[0-9]{3}-?[0-9]{3}") // 0486123456 / 0123 456 789 / 0123-456-789 / 123456789 / 123 456 789 / 123-456-789
    private String telephone;
    @NotNull
    private Address address;
    private Set<Long> childrenId = new HashSet<>();
}
