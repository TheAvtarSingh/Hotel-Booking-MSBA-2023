package com.paymentservice.service;

import org.springframework.http.ResponseEntity;

import com.paymentservice.entity.TransactionDetailsEntity;

public interface TransactionService {

ResponseEntity<Integer> performTransaction(TransactionDetailsEntity newTransaction);
Integer findTransactionID(TransactionDetailsEntity newTransaction);
}
