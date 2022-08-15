package com.metaltravelguide.places.models.forms;

import com.metaltravelguide.places.models.entities.Address;
import com.metaltravelguide.places.models.entities.Contact;
import com.metaltravelguide.places.models.entities.Type;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PlaceAddForm {
    private String googleId;
    @NotBlank
    private String name;
    @NotNull
    private Address address;
    @NotNull
    private Contact contact;
    @NotNull
    private Type type;
    @NotBlank
    private String username;
}
