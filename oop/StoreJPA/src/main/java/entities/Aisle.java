package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aisle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aisle {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="aisle_id", nullable = false)
    private int aisleId;
    @Column(name ="type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    // constructor
    public Aisle(String type) {
        this.type = type;
    }

    // methods
    @Override
    public String toString() {
        return "Aisle{" +
                "id=" + aisleId +
                ", type='" + type + '\'' +
                '}';
    }
}
