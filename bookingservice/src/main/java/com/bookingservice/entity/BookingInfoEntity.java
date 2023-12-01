package com.bookingservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Booking Entity For Booking Table

@Entity
@Table(name = "Booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	private Date fromDate;

	private Date toDate;

	private String aadharNumber;

	private int numOfRooms;

	private String roomNumbers;

	@Column(nullable = false)
	private int roomPrice;

	private int transactionId = 0;

	private Date bookedOn;
}
