package com.example.demorest.models.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReservationCancelForm {
    private boolean canceled = true;
    @NotNull
    private String reason;
}
