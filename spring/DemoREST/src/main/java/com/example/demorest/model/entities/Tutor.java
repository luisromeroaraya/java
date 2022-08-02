package com.example.demorest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor extends Person {
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String address;
    @ManyToMany(mappedBy = "tutors")
    private Set<Child> children;

    public Tutor(String firstName, String lastName, String telephone, String address) {
        super(firstName, lastName);
        this.telephone = telephone;
        this.address = address;
    }

    public Tutor(String firstName, String lastName, String telephone, String address, Set<Child> children) {
        super(firstName, lastName);
        this.telephone = telephone;
        this.address = address;
        this.children = children;
    }
}
