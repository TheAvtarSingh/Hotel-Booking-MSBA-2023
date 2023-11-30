package com.bookingservice.service;

import java.sql.Date;

import com.bookingservice.entity.BookingInfoEntity;

public interface BookingInfoService {

	public BookingInfoEntity getBookingQuote(BookingInfoEntity bookingInfoEntity);
	
}
