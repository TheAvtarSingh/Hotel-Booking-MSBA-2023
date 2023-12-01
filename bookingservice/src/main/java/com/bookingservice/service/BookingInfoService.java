package com.bookingservice.service;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.entity.BookingInfoEntity;

public interface BookingInfoService {

	public BookingInfoResponseDTO getBookingQuote(BookingInfoEntity bookingInfoEntity);
	public BookingInfoEntity updateTransactionId(int bookingId, int transactionId);
	public BookingInfoEntity getBookingByTransactionId(int transactionId);
	
}
