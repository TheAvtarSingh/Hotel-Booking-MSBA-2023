package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.dto.TransactionRequestDTO;
import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.exceptions.classes.BookingConflictException;
import com.bookingservice.service.BookingInfoService;

@RestController
@RequestMapping("/hotel")
public class BookingInfoController {

	@Autowired
	private BookingInfoService bookingService;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@PostMapping("/booking")
	public ResponseEntity<BookingInfoResponseDTO> bookHotel(@RequestBody BookingInfoEntity newBookingData) {
		// Check existing entity
		try {

			// Check if required fields are present
			if (newBookingData.getFromDate() == null || newBookingData.getToDate() == null
					|| newBookingData.getAadharNumber() == null || newBookingData.getNumOfRooms() == 0) {
				throw new BookingConflictException(
						"Either fromDate or toDate or aadharNumber or numOfRooms is Missing !!",
						HttpStatus.BAD_REQUEST);
			}

			// Check existing entity
			BookingInfoResponseDTO newBookingWithFlag = bookingService.getBookingQuote(newBookingData);
			if (newBookingWithFlag == null) {
				throw new BookingConflictException(
						"Data with Same Aadhar Number and widthin same date already exists !!", HttpStatus.CONFLICT);
			}
			return new ResponseEntity<>(newBookingWithFlag, HttpStatus.CREATED);
		} catch (BookingConflictException ex) {
			throw ex;
		}
	}

	@PostMapping("/booking/{bookingId}/transaction")
	public ResponseEntity<?> confirmBooking(@PathVariable int bookingId,
			@RequestBody TransactionRequestDTO confirmTransaction) {
		if (bookingId != confirmTransaction.getBookingId()) {
			throw new BookingConflictException("Booking ID Should be Same in Both Body and Path !!",
					HttpStatus.BAD_REQUEST);
		}
		
		if ((!confirmTransaction.getPaymentMode().equalsIgnoreCase("UPI"))
		        && (!confirmTransaction.getPaymentMode().equalsIgnoreCase("CARD"))) {
		    throw new BookingConflictException("Invalid Form of Payment !!", HttpStatus.BAD_REQUEST);
		}


		try {

			String transactionServiceUrl = "http://localhost:9191/payment";

			WebClient transactionWebClient = webClientBuilder.baseUrl(transactionServiceUrl).build();

			String transactionEndpoint = "/transaction";

			ResponseEntity<Integer> transactionIDResponse = transactionWebClient
					.post().uri(transactionEndpoint)
					.contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters
					.fromValue(confirmTransaction))
					.retrieve().toEntity(Integer.class).block();
			
//			System.out.println(transactionIDResponse.getBody());

			if (transactionIDResponse.getStatusCode().is2xxSuccessful()) {

				BookingInfoEntity updateResponse = updateTransactionId(bookingId, transactionIDResponse.getBody());
				
	
		            	String message = "Booking confirmed for user with aadhaar number: "
		                        + updateResponse.getAadharNumber()
		                        + " | "
		                        + "Here are the booking details: " + updateResponse.toString();

		                // Print or return the message as needed
		                System.out.println(message);
		               
		          

				
				if (updateResponse != null) {
					return new ResponseEntity<>(updateResponse, HttpStatus.CREATED);
				}

			}
			
		} catch (Exception e) {
			// TODO: handle exception

			throw new BookingConflictException("Invalid Booking Id", HttpStatus.BAD_REQUEST);
		}
		throw new BookingConflictException("Transaction Not Existed !!", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateTransactionId/{bookingId}")
	public BookingInfoEntity updateTransactionId(@PathVariable int bookingId, @RequestBody int transactionId) {

		// Call your service method to update the transaction ID for the given booking
		// ID
		BookingInfoEntity updatedEntity = bookingService.updateTransactionId(bookingId, transactionId);

		if (updatedEntity != null) {
			return updatedEntity;
		}
		throw new BookingConflictException("Booking Does Not Exists !!", HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/getBookingByTransId/{transactionId}")
	public BookingInfoEntity getBookingInfoByTransID(@PathVariable int transactionId) {
		
		BookingInfoEntity availableEntity = bookingService.getBookingByTransactionId(transactionId);
		if (availableEntity!=null) {
			return availableEntity;
		}
		throw new BookingConflictException("Booking with Transaction ID "+transactionId+"Does Not Exists !!", HttpStatus.NOT_FOUND);
	}
}
