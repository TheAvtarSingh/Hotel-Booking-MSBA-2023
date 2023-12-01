package com.paymentservice.exception.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.paymentservice.exception.classes.TransactionsException;
 

@RestControllerAdvice
public class TransactionExceptionHandler {
	@ExceptionHandler(TransactionsException.class)
    public ResponseEntity<Object> handleBookingConflict(TransactionsException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<String, Object>();
       

        body.put("message", ex.getMessage());
        body.put("status code", ex.getStatus().value());
        return new ResponseEntity<>(body, ex.getStatus());
    }
}
