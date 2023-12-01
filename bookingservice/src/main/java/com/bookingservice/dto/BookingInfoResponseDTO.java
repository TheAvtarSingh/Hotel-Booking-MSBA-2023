package com.bookingservice.dto;

import java.util.Date;


import lombok.Data;

@Data
// This Class is Made for Sending Out Hidden Response to Post Request Sending/Recieving BookingInfoEntity
public class BookingInfoResponseDTO {
private int id;
private Date fromDate;
private Date toDate;
private String aadharNumber;
private String roomNumbers;
private int roomPrice;
private int transactionId;
private Date bookedOn;




}
