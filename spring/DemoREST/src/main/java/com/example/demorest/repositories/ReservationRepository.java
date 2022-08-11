package com.example.demorest.repositories;

import com.example.demorest.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select r from Reservation r where r.timeArrival between ?1 and ?2 and r.canceled = false")
    List<Reservation> findByTimeArrivalBetweenAndCanceledIsFalse(LocalDateTime today, LocalDateTime tomorrow);

    @Query("select r from Reservation r where r.child.id = ?1 and r.timeArrival > ?2 and r.canceled = false")
    List<Reservation> findByChild_IdAndTimeArrivalAfterAndCanceledIsFalse(Long id, LocalDateTime date);

    @Query("select count(r) from Reservation r where r.timeArrival between ?1 and ?2 and r.canceled = false")
    Long countByTimeArrivalBetweenAndCanceledIsFalse(LocalDateTime now, LocalDateTime endOfMonth);






}
