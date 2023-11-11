package com.university.booking_university_project.modules.reservation.repository;

import com.university.booking_university_project.jpa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  @Query(value = "select exists(select * from public.reservation r where " +
          "r.apartment_id = :apartmentId " +
          "and r.reservation_status = 'ACTIVE' " +
          "and (:startDate >= r.start_date and :startDate <= r.end_date" +
          "     or :endDate >= r.start_date and :endDate <= r.end_date))", nativeQuery = true)
  boolean isReservationExistsForApartmentInDates(Integer apartmentId, Timestamp startDate, Timestamp endDate);
}
