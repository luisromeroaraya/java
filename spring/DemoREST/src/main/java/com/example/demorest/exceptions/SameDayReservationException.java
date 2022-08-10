package com.example.demorest.exceptions;

import java.time.LocalDateTime;

public class SameDayReservationException extends IllegalArgumentException {
    private final LocalDateTime timeArrival;
    private final LocalDateTime timeDeparture;


    public SameDayReservationException(LocalDateTime timeArrival, LocalDateTime timeDeparture) {
        super("Day of arrival and day of departure must be the same. " + timeArrival.getDayOfMonth() + "/" + timeArrival.getMonthValue() + "/" + timeArrival.getYear() + " is different from " + timeDeparture.getDayOfMonth() + "/" + timeDeparture.getMonthValue() + "/" + timeDeparture.getYear());
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
    }
}
