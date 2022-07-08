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
public class Aisle {
    @Id
    @Column(name ="aisle_id")
    private int aisleId;
    @Column(name ="type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // methods
    @Override
    public String toString() {
        return "Aisle{" +
                "id=" + aisleId +
                ", type='" + type + '\'' +
                '}';
    }
}
