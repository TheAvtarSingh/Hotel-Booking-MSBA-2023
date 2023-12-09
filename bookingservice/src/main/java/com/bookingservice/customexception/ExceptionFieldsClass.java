package com.bookingservice.customexception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionFieldsClass {
	String message;
	int statusCode;
}
