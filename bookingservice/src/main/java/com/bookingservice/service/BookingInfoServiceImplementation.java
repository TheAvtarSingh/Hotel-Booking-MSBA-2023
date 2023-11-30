package com.bookingservice.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.repository.BookingInfoRepository;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {
	
	@Autowired
	private BookingInfoRepository bookingInfoRepository;

	@Override
	public BookingInfoEntity getBookingQuote(BookingInfoEntity bookingInfoEntity) {
		// TODO Auto-generated method stub
		
		bookingInfoEntity.setBookedOn(bookingInfoEntity.getFromDate());
		bookingInfoEntity.setRoomNumbers(generateRandomRoomNumbers(bookingInfoEntity.getNumOfRooms()));
		bookingInfoEntity.setRoomPrice(calculateRoomPrice(bookingInfoEntity.getNumOfRooms(), bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate()));
		
	
		return 	bookingInfoRepository.save(bookingInfoEntity);
	}
	
	
	 private String generateRandomRoomNumbers(int numOfRooms) {
	  
	        Random random = new Random();
	        
	        StringJoiner joiner = new StringJoiner(", ");
	       

	      

	        // Generate 'numOfRooms' random room numbers
	        for (int i = 0; i < numOfRooms; i++) {
	            String roomNumber = ""+(random.nextInt(100) + 1); 
	            joiner.add(roomNumber);
	        }
	        String result = joiner.toString();

	        return result;
	    }
	 
	 private int calculateRoomPrice(int numOfRooms, Date fromDate, Date toDate) {
		    int basePricePerRoomPerDay = 1000;
		    long numberOfDays = TimeUnit.MILLISECONDS.toDays(toDate.getTime() - fromDate.getTime());
		    return (int) ((Integer)basePricePerRoomPerDay * numOfRooms * numberOfDays);
		}

}
