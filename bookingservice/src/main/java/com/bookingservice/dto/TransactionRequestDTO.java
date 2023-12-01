package com.bookingservice.dto;

import lombok.Data;

// This Class is Made For Request Accepting the Transaction Entity
@Data
public class TransactionRequestDTO {

    private String paymentMode;

    private int bookingId;

    private String upiId;

    private String cardNumber;
}
