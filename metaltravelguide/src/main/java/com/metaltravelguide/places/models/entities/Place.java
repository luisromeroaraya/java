package com.metaltravelguide.places.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "places")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;
    private String googleId;
    @Column(nullable = false)
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Contact contact;
    private Type type;
    private boolean status = false;
    private LocalDateTime submit_date = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Place(String name, Address address, Contact contact, Type type) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.type = type;
    }

    public Place(String name, Address address, Contact contact, Type type, User user) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.user = user;
    }
}
