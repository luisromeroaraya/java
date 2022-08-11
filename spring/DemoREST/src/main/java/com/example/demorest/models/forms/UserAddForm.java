package com.example.demorest.models.forms;

import com.example.demorest.models.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserAddForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User toEntity() {
        User entity = new User();
        entity.setUsername(username);
        entity.setPassword(password);
        return entity;
    }
}
