package com.paymentservice.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.paymentservice.customexception.TransactionsException;
import com.paymentservice.entity.TransactionDetailsEntity;

@Component
public class RequestValidator {

    public Boolean validateTransactionRequest(TransactionDetailsEntity newTransaction) {
    	
        if (newTransaction.getBookingId() == 0) {
            throw new TransactionsException("Invalid Booking ID in Request Body", HttpStatus.BAD_REQUEST);
        }

        // Payment Mode Valid
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
        
//		Checking Payment Mode and Throwing Exception
		if ((!newTransaction.getPaymentMode().equalsIgnoreCase("UPI"))
				&& (!newTransaction.getPaymentMode().equalsIgnoreCase("CARD"))) {
			throw new TransactionsException("Invalid Form of Payment !!", HttpStatus.BAD_REQUEST);
		}
        return true;
        

    }
    
    public void validateTransactionParameters(int transactionId) {
    	if (transactionId <=0) {

            throw new TransactionsException("Transaction Id is not valid !!", HttpStatus.BAD_REQUEST);
		}
    	return ;
    }
}