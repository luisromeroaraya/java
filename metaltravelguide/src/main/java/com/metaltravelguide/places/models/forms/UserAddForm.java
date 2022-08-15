package com.metaltravelguide.places.models.forms;

import com.metaltravelguide.places.models.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UserAddForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String mail;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    private String country_iso;


    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setMail(mail);
        user.setCountry_iso(country_iso);
        return user;
    }
}