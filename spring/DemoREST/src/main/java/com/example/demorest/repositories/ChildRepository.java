package com.example.demorest.repositories;

import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    @Query("select c from Child c where c.firstName = ?1")
    List<Child> findByFirstName(String name);
}
