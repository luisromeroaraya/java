package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "director")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="director_id", nullable = false)
    private int directorId;
    @Column(name ="firstname", nullable = false)
    private String firstName;
    @Column(name ="lastname", nullable = false)
    private String lastName;
    @Column(name ="salary", columnDefinition = "decimal(8,2)")
    private double salary;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
    // constructor
    public Director(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

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
