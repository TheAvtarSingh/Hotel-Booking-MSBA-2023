package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.BookingInfoEntity;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Integer> {

}
