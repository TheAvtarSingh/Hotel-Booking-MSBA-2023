package com.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.customexception.TransactionsException;
import com.paymentservice.entity.TransactionDetailsEntity;
import com.paymentservice.service.TransactionService;
import com.paymentservice.validator.RequestValidator;

@RestController
@RequestMapping("/payment/")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/transaction")
//	Perform Transaction
	public ResponseEntity<?> performTransaction(@RequestBody @Validated TransactionDetailsEntity newTransaction) {

		try {
// Check Request Format
			requestValidator.validateTransactionRequest(newTransaction);
// Perform Transaction
			ResponseEntity<Integer> response = transactionService.performTransaction(newTransaction);

			// Check if the response status is CONFLICT (409) - If already Data Existed
			if (response.getStatusCode() == HttpStatus.CONFLICT) {
//				Get saved Id
				return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
			}

			// Return the response with the generated transaction ID and 201 status code
			return new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);

		} catch (Exception e) {
			// Handler other exceptions if needed
			throw e;
		}
	}

// Endpoint 4 -	Find Transaction by Transaction Id - Get Method
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<?> findTransactionById(@PathVariable int transactionId) {
		
		requestValidator.validateTransactionParameters(transactionId);
		TransactionDetailsEntity existingEntry = transactionService.findTransactionById(transactionId);
		if (existingEntry != null) {
			return new ResponseEntity<>(existingEntry, HttpStatus.OK);
		}
		throw new TransactionsException("No Transaction Exist for Given Data !!", HttpStatus.NOT_FOUND);
	}
// Find Transaction By Transction Entity Body - POST Method
	@PostMapping("/findtransaction")
	public ResponseEntity<?> findTransaction(@RequestBody TransactionDetailsEntity newTransaction) {

		Integer transactionId = transactionService.findTransactionID(newTransaction);

		if (transactionId != null) {
			return new ResponseEntity<>(transactionId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Not Found", HttpStatus.OK);
		}

	}

}
