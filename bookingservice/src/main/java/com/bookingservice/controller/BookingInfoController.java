package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.service.BookingInfoService;

@RestController
@RequestMapping("/hotel")
public class BookingInfoController {

	@Autowired
	private BookingInfoService bookingService;
	
	@PostMapping("/booking")
    public ResponseEntity<BookingInfoEntity> bookHotel(@RequestBody BookingInfoEntity newBookingData) {
        // Check existing entity
        BookingInfoEntity existingBooking = bookingService.getBookingQuote(newBookingData);
        return new ResponseEntity<>(existingBooking, HttpStatus.CREATED);
    }
}
