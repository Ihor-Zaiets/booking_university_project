package com.university.booking_university_project.modules.apartment.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class ApartmentUpdateDTO {
  
  private Integer id;

  @NonNull private Integer numberOfRooms;

  private Double square;

  @NonNull private Double rentPrice;

  private Integer floor;

  private String description;

  @NonNull private Integer numberOfDoubleBeds;

  @NonNull private Integer numberOfSingleBeds;
}
