package com.university.booking_university_project.modules.apartment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApartmentDTO {

    private Integer id;

    private Integer numberOfRooms;

    private Double square;

    private Double rentPrice;

    private Integer floor;

    private String description;

    private Integer numberOfDoubleBeds;

    private Integer numberOfSingleBeds;

    private String address;
}
