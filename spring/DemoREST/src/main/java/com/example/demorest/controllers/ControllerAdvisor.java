package com.example.demorest.controllers;

import com.example.demorest.exceptions.*;
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

    @ExceptionHandler(NullElementException.class)
    public ResponseEntity<?> handleException(NullElementException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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

    @ExceptionHandler(ReservationsLimitReachedException.class)
    public ResponseEntity<?> handleException(ReservationsLimitReachedException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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

    @ExceptionHandler(SameDayReservationException.class)
    public ResponseEntity<?> handleException(SameDayReservationException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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

    @ExceptionHandler(WrongDepartureTimeException.class)
    public ResponseEntity<?> handleException(WrongDepartureTimeException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
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
