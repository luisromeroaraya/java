package com.metaltravelguide.places.models.dtos;

import com.metaltravelguide.places.models.entities.Address;
import com.metaltravelguide.places.models.entities.Contact;
import com.metaltravelguide.places.models.entities.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {
    private Long id;
    private String googleId;
    private String name;
    private Address address;
    private Contact contact;
    private Type type;
    private Long userId;
}