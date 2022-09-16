package org.example.models;

import lombok.*;
import lombok.experimental.NonFinal;

import java.time.LocalDate;

@EqualsAndHashCode(of = {"firstName", "lastName"})
@ToString
@NoArgsConstructor(onConstructor_ = { @Deprecated() })
public class Person {

    @ToString.Exclude
    @Getter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @ToString.Exclude
    @Getter
    @Builder.Default
    private LocalDate birthDate = LocalDate.now();
}
