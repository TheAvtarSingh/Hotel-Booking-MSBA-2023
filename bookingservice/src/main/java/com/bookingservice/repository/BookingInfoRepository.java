package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.BookingInfoEntity;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Integer> {
    List<BookingInfoEntity> findAllByAadharNumberAndFromDateLessThanEqualAndToDateGreaterThanEqual(
            String aadharNumber, Date fromDate, Date toDate);
    
    BookingInfoEntity findByBookingId(int bookingId);

}
