package com.bookingservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// This Class is Made For Request Accepting the Transaction Entity
@Data
public class TransactionRequestDTO {
@NotBlank
    private String paymentMode;
@NotBlank
    private int bookingId;
@NotBlank
    private String upiId;
@NotBlank
    private String cardNumber;
}
