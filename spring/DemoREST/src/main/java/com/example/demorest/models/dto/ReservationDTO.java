package com.example.demorest.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDateTime timeArrival;
    private LocalDateTime timeDeparture;
    private String canceled;
    private String reason;
    private Long childId;
    private Long tutorId;
}
