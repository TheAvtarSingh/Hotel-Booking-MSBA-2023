package com.bookingservice.service;

import com.bookingservice.businessLogics.BusinessLogicMethodClass;
import com.bookingservice.dto.BookingInfoResponseDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.repository.BookingInfoRepository;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {

	@Autowired
	private BookingInfoRepository bookingInfoRepository;

//	Object of Separate Class Containing complete logic
	BusinessLogicMethodClass logicMethodsClass = new BusinessLogicMethodClass();

	@Override
	public BookingInfoResponseDTO getBookingQuote(BookingInfoEntity bookingInfoEntity) {
		// TODO Auto-generated method stub
		
//		if There is a Booking within the date (from and to) and from already existed aadharNumber
	List<BookingInfoEntity> existingBooking = bookingInfoRepository.findAllByAadharNumberAndFromDateLessThanEqualAndToDateGreaterThanEqual(bookingInfoEntity.getAadharNumber(), bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
	 if (!existingBooking.isEmpty()) { 
         return null;
     }
	
//		 Save the Data

//		 Method for Random Room Numbers logic
		String randomRoomNumbers = logicMethodsClass.generateRandomRoomNumbers(bookingInfoEntity.getNumOfRooms());
		int calculatedRoomPrices = logicMethodsClass.calculateRoomPrice(bookingInfoEntity.getNumOfRooms(),
				bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());

//        Setting Up Additional Data
		bookingInfoEntity.setBookedOn(bookingInfoEntity.getFromDate());
		bookingInfoEntity.setRoomNumbers(randomRoomNumbers);
		bookingInfoEntity.setRoomPrice(calculatedRoomPrices);
		
		
		
		BookingInfoEntity bookedInfoEntity =  bookingInfoRepository.save(bookingInfoEntity);
		BookingInfoResponseDTO response =  logicMethodsClass.toDto(bookedInfoEntity);

		return response;
	

	}

}
