package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    private int directorId;
    private String firstName;
    private String lastName;
    private double salary;
    @OneToOne(mappedBy = "director")
    private Market market;
}
