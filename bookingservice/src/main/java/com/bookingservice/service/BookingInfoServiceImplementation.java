package com.bookingservice.service;

import com.bookingservice.customexception.BookingConflictException;
import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.dto.TransactionRequestDTO;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.logic.BusinessLogicMethodClass;
import com.bookingservice.repository.BookingInfoRepository;

@Service
public class BookingInfoServiceImplementation implements BookingInfoService {

	@Autowired
	private BookingInfoRepository bookingInfoRepository;

//	Business Logic class - Rooms and Pricing
	@Autowired
	private BusinessLogicMethodClass logicMethodsClass;
	
	@Autowired
	private RestTemplate restTemplate;

//	Object of Separate Class Containing complete logic -- Replaced By Component[Optional]
//	BusinessLogicMethodClass logicMethodsClass = new BusinessLogicMethodClass();

	@Override
	public BookingInfoResponseDTO getBookingQuote(BookingInfoEntity bookingInfoEntity) {
		// TODO Auto-generated method stub

//		if There is a Booking within the date (from and to) and from already existed aadharNumber
		List<BookingInfoEntity> existingBooking = bookingInfoRepository
				.findAllByAadharNumberAndFromDateLessThanEqualAndToDateGreaterThanEqual(
						bookingInfoEntity.getAadharNumber(), bookingInfoEntity.getFromDate(),
						bookingInfoEntity.getToDate());
		if (!existingBooking.isEmpty()) {
			return null;
		}

//		 Save the Data

//		 Method for Random Room Numbers logic
		String randomRoomNumbers = logicMethodsClass.generateRandomRoomNumbers(bookingInfoEntity.getNumOfRooms());
		int calculatedRoomPrices = logicMethodsClass.calculateRoomPrice(bookingInfoEntity.getNumOfRooms(),
				bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
		Date date = new Date();

//        Setting Up Additional Data
		bookingInfoEntity.setBookedOn(date);
		bookingInfoEntity.setRoomNumbers(randomRoomNumbers);
		bookingInfoEntity.setRoomPrice(calculatedRoomPrices);

		BookingInfoEntity bookedInfoEntity = bookingInfoRepository.save(bookingInfoEntity);
		BookingInfoResponseDTO response = logicMethodsClass.toDto(bookedInfoEntity);

		return response;

	}
	
	@Override
	public ResponseEntity<Integer> performPayment(TransactionRequestDTO confirmTransaction) {
		// TODO Auto-generated method stub
		String transactionServiceUrl = "http://localhost:9191/payment";
		String transactionEndpoint = "/transaction";
//Doing Transaction - EndPoint - 3 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<TransactionRequestDTO> requestEntity = new HttpEntity<>(confirmTransaction, headers);

//		WebClient transactionWebClient = webClientBuilder.baseUrl(transactionServiceUrl).build();

		ResponseEntity<Integer> transactionIDResponse = restTemplate.exchange(
				transactionServiceUrl + transactionEndpoint, HttpMethod.POST, requestEntity, Integer.class);
if(transactionIDResponse.getStatusCode().is2xxSuccessful()) {
	return transactionIDResponse;
}
throw new BookingConflictException("Unable to Perform Transaction !!",
		HttpStatus.BAD_REQUEST);
	}

	@Override
	public BookingInfoEntity updateTransactionId(int bookingId, int transactionId) {
		// TODO Auto-generated method stub
		BookingInfoEntity existingBooking = bookingInfoRepository.findByBookingId(bookingId);

		if (existingBooking != null) {
			existingBooking.setTransactionId(transactionId);
			BookingInfoEntity updatedBookingInfoEntity = bookingInfoRepository.save(existingBooking);
			return updatedBookingInfoEntity;
		}

		return null;
	}

	@Override
	public BookingInfoEntity getBookingByTransactionId(int transactionId) {
		// TODO Auto-generated method stub
		BookingInfoEntity availableBooking = bookingInfoRepository.findByTransactionId(transactionId);
		if (availableBooking != null) {
			return availableBooking;
		}
		return null;

	}



}
