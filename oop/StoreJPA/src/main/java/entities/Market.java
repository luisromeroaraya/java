package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Market {
    @Id
    private String marketId;
    private String name;
    private String street;
    private int number;
    private String city;
    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
