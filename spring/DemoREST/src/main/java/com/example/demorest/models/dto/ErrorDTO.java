package com.example.demorest.models.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ErrorDTO {
    private LocalDateTime receivedAt;
    private HttpMethod method;
    private int status;
    private String path;
    private String message;
    private Map<String, Object> infos = new HashMap<>();

    public ErrorDTO addInfo(String key, Object value) {
        infos.put(key, value);
        return this;
    }
}