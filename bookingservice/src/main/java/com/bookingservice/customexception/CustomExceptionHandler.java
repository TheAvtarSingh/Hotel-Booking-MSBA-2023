package com.bookingservice.customexception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookingConflictException.class)
    public ResponseEntity<Object> handleBookingConflict(BookingConflictException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<String, Object>();
       

        body.put("message", ex.getMessage());
        body.put("status code", ex.getStatus().value());
        return new ResponseEntity<>(body, ex.getStatus());
    }
}

