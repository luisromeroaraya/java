package com.example.demorest.controllers;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.exceptions.ElementsNotFoundException;
import com.example.demorest.exceptions.ReservationsLimitReached;
import com.example.demorest.models.dto.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice // here we will handle all the controller exceptions messages
public class ControllerAdvisor {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<?> handleException(ElementNotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt( LocalDateTime.now() )
                                .status(404)
                                .method( HttpMethod.resolve(req.getMethod()) )
                                .path( req.getRequestURL().toString() )
                                .build()
                );
    }

    @ExceptionHandler(ElementsNotFoundException.class)
    public ResponseEntity<?> handleException(ElementsNotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt( LocalDateTime.now() )
                                .status(404)
                                .method( HttpMethod.resolve(req.getMethod()) )
                                .path( req.getRequestURL().toString() )
                                .build()
                );
    }

    @ExceptionHandler(ReservationsLimitReached.class)
    public ResponseEntity<?> handleException(ReservationsLimitReached ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt( LocalDateTime.now() )
                                .status(400)
                                .method( HttpMethod.resolve(req.getMethod()) )
                                .path( req.getRequestURL().toString() )
                                .build()
                );
    }
}
