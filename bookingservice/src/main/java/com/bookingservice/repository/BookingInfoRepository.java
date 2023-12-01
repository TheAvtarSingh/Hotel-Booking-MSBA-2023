package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.BookingInfoEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Integer> {
//	Method to Check for Existing Booking with Same Data
	List<BookingInfoEntity> findAllByAadharNumberAndFromDateLessThanEqualAndToDateGreaterThanEqual(String aadharNumber,
			Date fromDate, Date toDate);

//    Find Booking By Booking Id
	BookingInfoEntity findByBookingId(int bookingId);

//    Find Booking by Transaction Id
	BookingInfoEntity findByTransactionId(int transactionId);

}
