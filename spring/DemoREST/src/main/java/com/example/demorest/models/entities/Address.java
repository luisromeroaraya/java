package com.example.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable // these columns are going to be added to the parent's Entity table (Tutor)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "address_street", nullable = false)
    private String street;
    @Column(name = "address_number", nullable = false)
    private int number;
    @Column(name = "address_extra")
    private String extra;
    @Column(name = "address_city", nullable = false)
    private String city;
    @Column(name = "address_region", nullable = false)
    private String region;
    @Column(name = "address_zip", nullable = false)
    private int zip;
}
