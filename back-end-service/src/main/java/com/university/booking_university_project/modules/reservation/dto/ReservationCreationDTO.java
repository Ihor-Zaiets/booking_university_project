package com.university.booking_university_project.modules.reservation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReservationCreationDTO extends ReservationUpdateDTO {

    @JsonIgnore
    @Override
    public Integer getId() {
        return super.getId();
    }
}
