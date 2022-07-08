package entities;

import jakarta.persistence.*;
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
    @Column(name ="director_id")
    private int directorId;
    @Column(name ="firstname")
    private String firstName;
    @Column(name ="lastname")
    private String lastName;
    @Column(name ="salary", columnDefinition = "decimal(8,2)")
    private double salary;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // methods
    @Override
    public String toString() {
        return "Director{" +
                "id=" + directorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
