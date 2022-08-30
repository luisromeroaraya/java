package com.metaltravelguide.places.models.forms;

import com.metaltravelguide.places.models.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserAddForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String mail;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String countryIso;
}