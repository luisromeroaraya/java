package com.example.demorest.exceptions;

import java.time.LocalDateTime;

public class ReservationsLimitReachedException extends RuntimeException {
    private final LocalDateTime dateTime;
    public ReservationsLimitReachedException(LocalDateTime dateTime) {
        super("Can't book more reservations for " + dateTime.getDayOfMonth() + "/" + dateTime.getMonthValue() + "/" + dateTime.getYear() + ". The limit of 10 reservations per day has already been reached.");
        this.dateTime = dateTime;
    }
}
