package com.bookingservice.validators;



import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.exceptions.classes.BookingConflictException;



@Component
public class RequestValidators {

//    public Boolean validateTransactionRequest( BookingInfoEntity newBookingData ) {
//    	
//        if (newBookingData.getBookingId() == 0) {
//            throw new BookingConflictException("Invalid Booking Id!!", HttpStatus.BAD_REQUEST);
//        }
//
//        // Add more custom validations as needed
//        if (newBookingData.getAadharNumber() == null || newBookingData..isEmpty()) {
//            throw new TransactionsException("Payment Mode cannot be empty", HttpStatus.BAD_REQUEST);
//        }
//
//
//        // Example: Check if paymentMode is UPI, then upiId should be present
//        if ("UPI".equalsIgnoreCase(newTransaction.getPaymentMode()) && 
//            (newTransaction.getUpiId() == null || newTransaction.getUpiId().isEmpty())) {
//            throw new TransactionsException("UPI ID is required for UPI payments", HttpStatus.BAD_REQUEST);
//        }
//        
//        if ("CARD".equalsIgnoreCase(newTransaction.getPaymentMode()) && 
//        	    (newTransaction.getCardNumber() == null || newTransaction.getCardNumber().isEmpty())) {
//        	    throw new TransactionsException("Card Number is required for CARD payments", HttpStatus.BAD_REQUEST);
//        	}
//        return true;
//    }
}
