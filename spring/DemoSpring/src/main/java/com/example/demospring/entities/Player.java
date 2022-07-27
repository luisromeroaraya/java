// Entity is how the Player is stored in the database

package com.example.demospring.entities;

import com.example.demospring.utils.Position;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data // https://projectlombok.org/features/Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(columnDefinition = "DATE")
    LocalDate birthdate;

    @Column()
    int number;

    @Column()
    double salary;

    @Column()
    @Enumerated(EnumType.STRING)
    Position position;
}
