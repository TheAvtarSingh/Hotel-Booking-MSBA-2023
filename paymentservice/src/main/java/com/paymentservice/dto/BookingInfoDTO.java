package com.paymentservice.dto;

import java.util.Date;

import lombok.Data;



@Data
public class BookingInfoDTO {
	 private int bookingId;
	 
	    private Date fromDate;

	    private Date toDate;

	    private String aadharNumber;

	    private int numOfRooms;

	    private String roomNumbers;
	    
	  
	    private int roomPrice;

	    private int transactionId=0;

	    private Date bookedOn;
}
