package com.example.demorest.services.implementation;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.ReservationsLimitReached;
import com.example.demorest.mapper.ReservationMapper;
import com.example.demorest.models.dto.ReservationDTO;
import com.example.demorest.models.entities.Reservation;
import com.example.demorest.models.forms.ReservationAddForm;
import com.example.demorest.models.forms.ReservationCancelForm;
import com.example.demorest.repositories.ReservationRepository;
import com.example.demorest.services.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDTO getOne(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(Reservation.class, id));
    }

    @Override
    public List<ReservationDTO> getAll() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO create(ReservationAddForm reservationAddForm) {
        if (reservationAddForm == null)
            throw new IllegalArgumentException("Reservation can't be null.");
        if (reservationAddForm.getTimeArrival().getDayOfYear() != reservationAddForm.getTimeDeparture().getDayOfYear())
            throw new IllegalArgumentException("Day of arrival and day of departure must be the same.");
        if (getReservationsForDate(reservationAddForm.getTimeArrival().toLocalDate()).size() >= 10)
            throw new ReservationsLimitReached(reservationAddForm.getTimeArrival());
        Reservation reservation = reservationMapper.toEntity(reservationAddForm);
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(reservation);
    }

    @Override
    public ReservationDTO update(Long id, ReservationCancelForm reservationCancelForm) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(Reservation.class, id));
        if (reservationCancelForm == null)
            throw new IllegalArgumentException("Reservation can't be null.");
        reservation.setCanceled(reservationCancelForm.isCanceled());
        reservation.setReason(reservationCancelForm.getReason());
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(reservation);
    }

    @Override
    public ReservationDTO delete(Long id) {
        return null;
    }

    @Override
    public List<ReservationDTO> getReservationsForDate(LocalDate date) {
        return reservationRepository.findByTimeArrivalBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay()).stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> getReservationsLeftForThisMonth() {
        return reservationRepository.findByTimeArrivalBetween(LocalDateTime.now(), LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay()).stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
