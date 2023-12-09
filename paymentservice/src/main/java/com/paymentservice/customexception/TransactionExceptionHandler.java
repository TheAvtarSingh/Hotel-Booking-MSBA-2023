package com.paymentservice.customexception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
 

@RestControllerAdvice
public class TransactionExceptionHandler {
	
//	Local Level
	@ExceptionHandler(TransactionsException.class)
    public ResponseEntity<Object> handleBookingConflict(TransactionsException ex, WebRequest request) {
		TransactionExceptionFieldClass exfields = new TransactionExceptionFieldClass(ex.getMessage(), ex.getStatus().value());
		/*
		 * Map<String, Object> body = new LinkedHashMap<String, Object>();
		 * 
		 * 
		 * body.put("message", ex.getMessage()); body.put("status code",
		 * ex.getStatus().value());
		 */
        return new ResponseEntity<>(exfields, ex.getStatus());
    }
	
//	Global Level
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleTransactionException(Exception ex,WebRequest request){
		TransactionExceptionFieldClass exfields = new TransactionExceptionFieldClass(ex.getMessage(),500);
		return new ResponseEntity<>(exfields,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
