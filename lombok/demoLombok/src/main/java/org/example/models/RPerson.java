package org.example.models;

import java.time.LocalDate;

public record RPerson(Long id, String firstName, String lastName, LocalDate birthDate){
}
