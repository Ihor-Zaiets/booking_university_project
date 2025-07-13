package com.university.booking_university_project.modules.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationUpdateDTO {
    private Integer id;

    @Mapping("apartment.id")
    private Integer apartmentId;

    @Mapping("user.id")
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp endDate;

    private Integer numberOfPeople;

    private Integer price;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
}
