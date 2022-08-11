package com.example.demorest.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WrongDepartureTimeException extends IllegalArgumentException {
    private final LocalDateTime timeArrival;
    private final LocalDateTime timeDeparture;

    public WrongDepartureTimeException(LocalDateTime timeArrival, LocalDateTime timeDeparture) {
        super("Time of arrival must be before the time of departure. " + timeArrival.format(DateTimeFormatter.ofPattern("hh:mm:ss")) + " is after " + timeDeparture.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
    }
}
