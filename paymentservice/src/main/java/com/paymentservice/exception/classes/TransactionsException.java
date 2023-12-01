package com.paymentservice.exception.classes;

import org.springframework.http.HttpStatus;

public class TransactionsException extends RuntimeException {
	private HttpStatus status;

	
	 public TransactionsException(String message,HttpStatus status) {
		
	        super(message);
	        this.status =status;
	    }
	 
	 public HttpStatus getStatus() {
	        return status;
	    }
}
