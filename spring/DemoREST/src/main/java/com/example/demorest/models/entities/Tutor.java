package com.example.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor extends Person {
    @Column(nullable = false)
    private String telephone;
    @Embedded
    private Address address;
    @ManyToMany(mappedBy = "tutors")
    private Set<Child> children = new HashSet<>();
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    public Tutor(String firstName, String lastName, String telephone, Address address) {
        super(firstName, lastName);
        this.telephone = telephone;
        this.address = address;
    }

    public Tutor(String firstName, String lastName, String telephone, Address address, Set<Child> children) {
        super(firstName, lastName);
        this.telephone = telephone;
        this.address = address;
        this.children = children;
    }
}
