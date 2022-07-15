package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private int roomId;
    @Column(name="description")
    private String description;
    @Column(name="floor")
    private int floor;
    @Column(name="capacity")
    private int capacity;
    @Column(name="beds")
    private int beds;
    @Column(name="available")
    private boolean available;
    @Column(name="price")
    private double price;
    @OneToMany(mappedBy="reservation")
    private List<Reservation> reservations;
}
