package com.paymentservice.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionExceptionFieldClass {
	String message;
	int statusCode;
}
