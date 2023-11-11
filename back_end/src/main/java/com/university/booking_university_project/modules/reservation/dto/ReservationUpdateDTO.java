package com.university.booking_university_project.modules.reservation.dto;

import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;

@Getter
@Setter
public class ReservationUpdateDTO {
  private Integer id;

  private Integer apartmentId;

  private Integer userId;

  @NonNull
  private Timestamp startDate;

  @NonNull private Timestamp endDate;

  @NonNull private Integer numberOfPeople;

  @NonNull private Integer price;

  @NonNull
  @Enumerated(EnumType.STRING)
  private ReservationStatus reservationStatus;
}
