package com.paymentservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailsEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int transactionId;

	    private String paymentMode;
	   
	   
	    @Column(nullable = false)
	    private int bookingId;

	    private String upiId;

	    private String cardNumber;

	   
}
