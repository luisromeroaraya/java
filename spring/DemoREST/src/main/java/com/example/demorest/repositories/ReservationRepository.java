package com.example.demorest.repositories;

import com.example.demorest.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select r from Reservation r where r.timeArrival between ?1 and ?2")
    List<Reservation> findByTimeArrivalBetween(LocalDateTime today, LocalDateTime tomorrow);

    @Query("select r from Reservation r where r.child.id = ?1 and r.timeArrival > ?2")
    List<Reservation> findByChild_IdAndTimeArrivalAfter(Long id, LocalDateTime date);
}
