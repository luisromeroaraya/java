package com.example.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReservationCreateForm {
    @NotNull
    private LocalDateTime timeArrival;
    @NotNull
    private LocalDateTime timeDeparture;
    private boolean canceled = false;
    private String reason = null;
    @NotNull
    private Long childId;
    @NotNull
    private Long tutorId;
}
