package com.university.booking_university_project.modules.reservation.repository;

import com.university.booking_university_project.jpa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  @Query(value = "Select true", nativeQuery = true)
  boolean isReservationExistsForApartmentInDates(Integer apartmentId, Timestamp startDate, Timestamp endDate);
}
