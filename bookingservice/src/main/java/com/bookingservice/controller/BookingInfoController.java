package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookingservice.customexception.BookingConflictException;
import com.bookingservice.dto.BookingInfoResponseDTO;
import com.bookingservice.dto.TransactionRequestDTO;
import com.bookingservice.entity.BookingInfoEntity;
import com.bookingservice.service.BookingInfoService;
import com.bookingservice.validator.RequestValidator;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class BookingInfoController {

	@Autowired
	private BookingInfoService bookingService;

	/*
	 * @Autowired private WebClient.Builder webClientBuilder;
	 */
	
	@Autowired
 	private RequestValidator validator;

	@Autowired
	private RestTemplate restTemplate;
// Endpoint - 1 -- Get Booking Details 
	@PostMapping("/booking")
	public ResponseEntity<BookingInfoResponseDTO> bookHotel(@Validated @RequestBody BookingInfoEntity newBookingData) {
		
		try {

			// Checking if required fields are present
			if (newBookingData.getFromDate() == null || newBookingData.getToDate() == null
					|| newBookingData.getAadharNumber() == null || newBookingData.getNumOfRooms() == 0) {
				throw new BookingConflictException(
						"Either fromDate or toDate or aadharNumber or numOfRooms is Missing !!",
						HttpStatus.BAD_REQUEST);
			}

			// Checking existing entity
			BookingInfoResponseDTO newBookingWithFlag = bookingService.getBookingQuote(newBookingData);
			if (newBookingWithFlag == null) {
				throw new BookingConflictException(
						"Data with Same Aadhar Number and widthin same date already exists !!", HttpStatus.CONFLICT);
			}
//			Else Returning Entity Data
			return new ResponseEntity<>(newBookingWithFlag, HttpStatus.CREATED);
		} catch (BookingConflictException ex) {
//			If any Exception Occur
			throw ex;
		}
	}

//	EndPoint - 2 -- Do Transaction With Booking Details
	
	@PostMapping("/booking/{bookingId}/transaction")
	public ResponseEntity<?> confirmBooking(@PathVariable int bookingId,
			@Valid	@RequestBody TransactionRequestDTO confirmTransaction) {
//		If Url and Request Body are Not Same
		if (bookingId != confirmTransaction.getBookingId()) {
			throw new BookingConflictException("Booking ID Should be Same in Both Body Request and Url Path !!",
					HttpStatus.BAD_REQUEST);
		}
		
		validator.validateTransactionRequest(confirmTransaction);


		
//		Inter-Service Communication

		try {

			String transactionServiceUrl = "http://localhost:9191/payment";
			String transactionEndpoint = "/transaction";
// Doing Transaction - EndPoint - 3 
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<TransactionRequestDTO> requestEntity = new HttpEntity<>(confirmTransaction, headers);

//			WebClient transactionWebClient = webClientBuilder.baseUrl(transactionServiceUrl).build();

			ResponseEntity<Integer> transactionIDResponse = restTemplate.exchange(
					transactionServiceUrl + transactionEndpoint, HttpMethod.POST, requestEntity, Integer.class);

			/*
			 * ResponseEntity<Integer> transactionIDResponse = transactionWebClient .post()
			 * .uri(transactionEndpoint) .contentType(MediaType.APPLICATION_JSON)
			 * .body(BodyInserters .fromValue(confirmTransaction)) .retrieve()
			 * .toEntity(Integer.class) .block();
			 */

//			System.out.println(transactionIDResponse.getBody());

			if (transactionIDResponse.getStatusCode().is2xxSuccessful()) {

				BookingInfoEntity updateResponse = updateTransactionId(bookingId, transactionIDResponse.getBody());

				String message = "Booking confirmed for user with aadhaar number: " + updateResponse.getAadharNumber()
						+ " | " + "Here are the booking details: " + updateResponse.toString();

				// Print or return the message as needed
				System.out.println(message);

				if (updateResponse != null) {
					return new ResponseEntity<>(updateResponse, HttpStatus.CREATED);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
// If Booking Id Not Exists
			throw new BookingConflictException("Invalid Booking Id", HttpStatus.BAD_REQUEST);
		}
//		If Transaction is not existed
		throw new BookingConflictException("Transaction Not Existed !!", HttpStatus.NOT_FOUND);
	}

//	Updation Method
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
// Testing Method
	@GetMapping("/getBookingByTransId/{transactionId}")
	public BookingInfoEntity getBookingInfoByTransID(@PathVariable int transactionId) {

		BookingInfoEntity availableEntity = bookingService.getBookingByTransactionId(transactionId);
		if (availableEntity != null) {
			return availableEntity;
		}
		throw new BookingConflictException("Booking with Transaction ID " + transactionId + "Does Not Exists !!",
				HttpStatus.NOT_FOUND);
	}
}
