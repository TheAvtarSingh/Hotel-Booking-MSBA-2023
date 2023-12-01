package com.bookingservice.logic;

import java.util.Date;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.entity.BookingInfoEntity;

@Component
public class BusinessLogicMethodClass {

//	Method to generate String of Random Room Numbers
	public String generateRandomRoomNumbers(int numOfRooms) {

		Random random = new Random();

		StringJoiner joiner = new StringJoiner(", ");

		// Generate 'numOfRooms' random room numbers
		for (int i = 0; i < numOfRooms; i++) {
			String roomNumber = "" + (random.nextInt(100) + 1);
			joiner.add(roomNumber);
		}
		String result = joiner.toString();

		return result;
	}

//Method for Calculating Room Prices

	public int calculateRoomPrice(int numOfRooms, Date fromDate, Date toDate) {
		int basePricePerRoomPerDay = 1000;
		long numberOfDays = TimeUnit.MILLISECONDS.toDays(toDate.getTime() - fromDate.getTime());
		return (int) ((Integer) basePricePerRoomPerDay * numOfRooms * numberOfDays);
	}

//	---------------------- Converters ----------------------------
	public BookingInfoResponseDTO toDto(BookingInfoEntity entity) {
		BookingInfoResponseDTO dto = new BookingInfoResponseDTO();
		dto.setId(entity.getBookingId());
		dto.setFromDate(entity.getFromDate());
		dto.setToDate(entity.getToDate());
		dto.setAadharNumber(entity.getAadharNumber());
		dto.setRoomNumbers(entity.getRoomNumbers());
		dto.setRoomPrice(entity.getRoomPrice());
		dto.setTransactionId(entity.getTransactionId());
		dto.setBookedOn(entity.getBookedOn());
		return dto;
	}
}
