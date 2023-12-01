package com.paymentservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.paymentservice.entity.TransactionDetailsEntity;
import com.paymentservice.repository.TransactionRepository;

@Service
public class TransactionServiceImplementation implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public ResponseEntity<Integer> performTransaction(TransactionDetailsEntity newTransaction) {
		// TODO Auto-generated method stub
//		Find if the Booking Exists
		TransactionDetailsEntity existingTransaction = transactionRepository
				.findByBookingId(newTransaction.getBookingId());

		// Transaction with the same booking ID already exists
		if (existingTransaction != null) {
			return new ResponseEntity<>(existingTransaction.getTransactionId(), HttpStatus.CONFLICT);
		}
		TransactionDetailsEntity savedTransaction = transactionRepository.save(newTransaction);

		Integer generatedId = savedTransaction.getTransactionId();

		return new ResponseEntity<>(generatedId, HttpStatus.CREATED);
	}

	@Override
	public Integer findTransactionID(TransactionDetailsEntity newTransaction) {
		// TODO Auto-generated method stub
		TransactionDetailsEntity existingEntity = transactionRepository.findByBookingId(newTransaction.getBookingId());

		if (existingEntity != null) {
			return existingEntity.getTransactionId();
		}
		return null;

	}

	@Override
	public TransactionDetailsEntity findTransactionById(int transactionId) {
		// TODO Auto-generated method stub
		TransactionDetailsEntity existedtransaction = transactionRepository.findByTransactionId(transactionId);
		if (existedtransaction != null) {
			return existedtransaction;
		}
		return null;
	}

}
