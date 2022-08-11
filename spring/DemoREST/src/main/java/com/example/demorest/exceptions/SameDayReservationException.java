package com.example.demorest.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SameDayReservationException extends IllegalArgumentException {
    private final LocalDateTime timeArrival;
    private final LocalDateTime timeDeparture;


    public SameDayReservationException(LocalDateTime timeArrival, LocalDateTime timeDeparture) {
        super("Day of arrival and day of departure must be the same. " + timeArrival.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " is different from " + timeDeparture.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
    }
}
