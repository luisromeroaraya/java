package com.example.demorest.exceptions;

import java.time.LocalDateTime;

public class WrongDepartureTimeException extends IllegalArgumentException {
    private final LocalDateTime timeArrival;
    private final LocalDateTime timeDeparture;

    public WrongDepartureTimeException(LocalDateTime timeArrival, LocalDateTime timeDeparture) {
        super("Time of arrival must be before the time of departure. " + timeArrival.getHour() + "h" + timeArrival.getMinute() + " is after " + timeDeparture.getHour() + "h" + timeDeparture.getMinute());
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
    }
}
