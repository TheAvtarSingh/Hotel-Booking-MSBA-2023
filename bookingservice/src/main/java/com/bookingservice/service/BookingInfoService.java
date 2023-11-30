package com.bookingservice.service;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.entity.BookingInfoEntity;

public interface BookingInfoService {

	public BookingInfoResponseDTO getBookingQuote(BookingInfoEntity bookingInfoEntity);
	
}
