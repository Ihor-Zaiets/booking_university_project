package com.university.booking_university_project.modules.reservation.repository;

import com.university.booking_university_project.jpa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
