package com.university.booking_university_project.modules.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;
import com.university.booking_university_project.jpa.enums.ReservationStatus;
import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {

    private Integer id;

    @Mapping("apartment.id")
    private Integer apartmentId;

    @Mapping("user.id")
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp endDate;

    private Integer numberOfPeople;

    private Integer price;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
}
