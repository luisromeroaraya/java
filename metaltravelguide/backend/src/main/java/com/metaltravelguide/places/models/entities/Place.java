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
    @Column(nullable = false, unique = true)
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Contact contact;
    private Type type;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;
    private boolean status = false;
    private LocalDateTime submit_date = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Place(String name, Address address, Contact contact, Type type, String description, String image) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public Place(String name, Address address, Contact contact, Type type, String description, String image, User user) {
        this(name, address, contact, type, description, image);
        this.user = user;
    }
}
