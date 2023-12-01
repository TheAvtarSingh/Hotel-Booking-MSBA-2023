package com.paymentservice.service;

import org.springframework.http.ResponseEntity;

import com.paymentservice.entity.TransactionDetailsEntity;

public interface TransactionService {
// Perform Transaction
ResponseEntity<Integer> performTransaction(TransactionDetailsEntity newTransaction);
// Find Transaction Id by Body
Integer findTransactionID(TransactionDetailsEntity newTransaction);
// Find Transactions Data by Transaction Id
TransactionDetailsEntity findTransactionById(int transactionId);
}
