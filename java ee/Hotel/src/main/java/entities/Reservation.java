package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int reservationId;
    @Column(name="date_start")
    private LocalDateTime dateStart;
    @Column(name="date_end")
    private LocalDateTime dateEnd;
    @Column(name="price")
    private double price;
    @Column(name="capacity")
    private int capacity;
    @ManyToOne()
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne()
    @JoinColumn(name="room_id")
    private Room room;
}
