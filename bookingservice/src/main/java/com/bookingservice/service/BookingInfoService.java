package com.bookingservice.service;

import org.springframework.http.ResponseEntity;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.dto.TransactionRequestDTO;
import com.bookingservice.entity.BookingInfoEntity;

public interface BookingInfoService {
// Compare Entered Booking Data with Database Data
	public BookingInfoResponseDTO getBookingQuote(BookingInfoEntity bookingInfoEntity);

//	Update TransactionId for Booking Data
	public BookingInfoEntity updateTransactionId(int bookingId, int transactionId);

//	Fetch Booking Data by Transaction Id
	public BookingInfoEntity getBookingByTransactionId(int transactionId);
	
//	perform Transaction
	public ResponseEntity<Integer> performPayment(TransactionRequestDTO confirmTransaction);

}
