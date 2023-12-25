package com.university.booking_university_project.modules.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequestDTO extends ReservationUpdateDTO {

    private Boolean isUserLogged;

    private String userFirstName;

    private String userPhoneNumber;
}
