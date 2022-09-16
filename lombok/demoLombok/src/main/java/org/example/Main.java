package org.example;

import org.example.models.Person;
import org.example.models.RPerson;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RPerson record = new RPerson(1L, "Flavien", "Ovyn", LocalDate.of(1991,7,1));
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Flavien");
        person.setLastName("Ovyn");
        person.setBirthDate(LocalDate.of(1991,7,1));
    }
}