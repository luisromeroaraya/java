// DTO is a new Player object that we return to the frontend with more or less attributes than the ones stored in the database

package com.example.demospring.models.dto;

import com.example.demospring.utils.Position;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data // https://projectlombok.org/features/Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDTO {
    Long id;
    String name;
    LocalDate birthdate;
    int age;
    int number;
    double salary;
    Position position;
}
