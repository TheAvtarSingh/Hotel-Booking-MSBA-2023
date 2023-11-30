package com.bookingservice.exceptions.classes;

import org.springframework.http.HttpStatus;

public class BookingConflictException extends RuntimeException {
	 private HttpStatus status;

	
	 public BookingConflictException(String message,HttpStatus status) {
		
	        super(message);
	        this.status =status;
	    }
	 
	 public HttpStatus getStatus() {
	        return status;
	    }
}
