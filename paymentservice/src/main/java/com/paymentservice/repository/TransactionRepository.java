package com.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentservice.entity.TransactionDetailsEntity;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Integer> {
TransactionDetailsEntity findByBookingId(int bookingId);

TransactionDetailsEntity findByTransactionId(int transactionId);
}
