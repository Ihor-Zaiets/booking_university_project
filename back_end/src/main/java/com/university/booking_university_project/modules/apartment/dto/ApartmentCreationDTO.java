package com.university.booking_university_project.modules.apartment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ApartmentCreationDTO extends ApartmentUpdateDTO {

    @JsonIgnore
    @Override
    public Integer getId() {
        return super.getId();
    }
}
