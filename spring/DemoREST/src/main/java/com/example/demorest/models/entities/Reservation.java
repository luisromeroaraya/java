package com.example.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime timeArrival;
    @Column(nullable = false)
    private LocalDateTime timeDeparture;
    private boolean canceled;
    private String reason;
    @ManyToOne
    @JoinColumn(name="child_id")
    private Child child;
    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;
}
