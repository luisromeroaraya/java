package com.example.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReservationAddForm {
    @NotNull
    private LocalDateTime timeArrival;
    @NotNull
    private LocalDateTime timeDeparture;
    private boolean canceled = false;
    private String reason = null;
    @NotNull
    private Long child_id;
    @NotNull
    private Long tutor_id;
}
