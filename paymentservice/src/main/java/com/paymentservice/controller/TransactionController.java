package com.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.entity.TransactionDetailsEntity;
import com.paymentservice.exception.classes.TransactionsException;
import com.paymentservice.logicClasses.RequestValidator;
import com.paymentservice.service.TransactionService;

@RestController
@RequestMapping("/payment/")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private RequestValidator requestValidator;

	@PostMapping("/transaction")
	public ResponseEntity<?> performTransaction(@RequestBody @Validated TransactionDetailsEntity newTransaction){
		
		
		
		 try {
			 
			   requestValidator.validateTransactionRequest(newTransaction);

			 
	            ResponseEntity<Integer> response = transactionService.performTransaction(newTransaction);
	            
	            Integer transactionId = response.getBody();

	            // Check if the response status is CONFLICT (409)
	            if (response.getStatusCode() == HttpStatus.CONFLICT) {
	                return new ResponseEntity<>(response.getBody(),HttpStatus.OK); 
	            }

	            // Return the response with the generated transaction ID and 201 status code
	            return new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);

	        } catch (Exception e) {
	            // Handle other exceptions if needed
	            throw e;
	        }
	}
	
	@PostMapping("/findtransaction")
	public ResponseEntity<?>findTransaction(@RequestBody TransactionDetailsEntity newTransaction){
		
			Integer transactionId = transactionService.findTransactionID(newTransaction);
			System.out.println(transactionId);
			if (transactionId!=null) {
			 return new ResponseEntity<>(transactionId, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
			}
			
		
	}
	
}
