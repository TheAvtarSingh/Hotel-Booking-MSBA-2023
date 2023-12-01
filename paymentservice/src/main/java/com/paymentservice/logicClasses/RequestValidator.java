package com.paymentservice.logicClasses;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.paymentservice.entity.TransactionDetailsEntity;
import com.paymentservice.exception.classes.TransactionsException;

@Component
public class RequestValidator {

    public Boolean validateTransactionRequest(TransactionDetailsEntity newTransaction) {
    	
        if (newTransaction.getBookingId() == 0) {
            throw new TransactionsException("Invalid Booking ID in Request Body", HttpStatus.BAD_REQUEST);
        }

        // Add more custom validations as needed
        if (newTransaction.getPaymentMode() == null || newTransaction.getPaymentMode().isEmpty()) {
            throw new TransactionsException("Payment Mode cannot be empty", HttpStatus.BAD_REQUEST);
        }


        // Example: Check if paymentMode is UPI, then upiId should be present
        if ("UPI".equalsIgnoreCase(newTransaction.getPaymentMode()) && 
            (newTransaction.getUpiId() == null || newTransaction.getUpiId().isEmpty())) {
            throw new TransactionsException("UPI ID is required for UPI payments", HttpStatus.BAD_REQUEST);
        }
        
        if ("CARD".equalsIgnoreCase(newTransaction.getPaymentMode()) && 
        	    (newTransaction.getCardNumber() == null || newTransaction.getCardNumber().isEmpty())) {
        	    throw new TransactionsException("Card Number is required for CARD payments", HttpStatus.BAD_REQUEST);
        	}
        return true;
    }
}