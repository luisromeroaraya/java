package jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "grade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grade {
    @Id
    @Column(name = "grade")
    private String grade;
    @Column(name = "lower_bound")
    private int lowerBound;
    @Column(name = "upper_bound")
    private int upperBound;
}
