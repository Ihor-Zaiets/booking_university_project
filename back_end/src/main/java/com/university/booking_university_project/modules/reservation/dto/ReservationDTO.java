package com.university.booking_university_project.modules.reservation.dto;

import com.university.booking_university_project.jpa.entity.Apartment;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;

@Getter
@Setter
public class ReservationDTO {

  private Integer id;

  private Integer apartment_id;

  private Integer user_id;

  @NonNull private Timestamp start_date;

  @NonNull private Timestamp end_date;

  @NonNull private Integer numberOfPeople;

  @NonNull private Integer price;

  @NonNull
  @Enumerated(EnumType.STRING)
  private ReservationStatus reservationStatus;
}
