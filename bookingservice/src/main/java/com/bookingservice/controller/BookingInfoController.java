package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.exceptions.classes.BookingConflictException;
import com.bookingservice.service.BookingInfoService;

@RestController
@RequestMapping("/hotel")
public class BookingInfoController {

	@Autowired
	private BookingInfoService bookingService;
	
	@PostMapping("/booking")
    public ResponseEntity<?> bookHotel(@RequestBody BookingInfoEntity newBookingData) {
        // Check existing entity
		 try {
			 
			// Check if required fields are present
		        if (newBookingData.getFromDate() == null || newBookingData.getToDate() == null ||
		            newBookingData.getAadharNumber() == null || newBookingData.getNumOfRooms() == 0) {
		            throw new BookingConflictException("From Date | ToDate | Aadhar Number | Number of Room is Missing !!",HttpStatus.BAD_REQUEST);
				       }

			 
		        // Check existing entity
		        BookingInfoResponseDTO newBookingWithFlag = bookingService.getBookingQuote(newBookingData);
		        if (newBookingWithFlag == null) {
		            throw new BookingConflictException("Data with Same Aadhar Number and widthin same date already exists !!",HttpStatus.CONFLICT);
		        }
		        return new ResponseEntity<>(newBookingWithFlag, HttpStatus.CREATED);
		    } catch (BookingConflictException ex) {
		        throw ex;
		    }
    }
}
