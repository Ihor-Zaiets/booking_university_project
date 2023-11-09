package com.university.booking_university_project.modules.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserCreateDTO extends UserUpdateDTO {

  @JsonIgnore
  @Override
  public Integer getId() {
    return super.getId();
  }
}
