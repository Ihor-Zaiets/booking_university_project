package com.university.booking_university_project.modules.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;
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

  @Mapping("apartment.id")
  private Integer apartmentId;

  @Mapping("user.id")
  private Integer userId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @NonNull private Timestamp startDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @NonNull private Timestamp endDate;

  @NonNull private Integer numberOfPeople;

  @NonNull private Integer price;

  @NonNull
  @Enumerated(EnumType.STRING)
  private ReservationStatus reservationStatus;
}
