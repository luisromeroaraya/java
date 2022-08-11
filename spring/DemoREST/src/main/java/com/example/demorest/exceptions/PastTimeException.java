package com.example.demorest.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PastTimeException extends IllegalArgumentException {
    private final LocalDateTime time;
    public PastTimeException(LocalDateTime time) {
        super("Invalid reservation date/time. " + time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")) + " is a past date/time.");
        this.time = time;
    }
}
