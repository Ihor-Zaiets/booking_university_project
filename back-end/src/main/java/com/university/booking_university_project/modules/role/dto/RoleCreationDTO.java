package com.university.booking_university_project.modules.role.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleCreationDTO extends RoleUpdateDTO {

    @JsonIgnore
    @Override
    public Integer getId() {
        return super.getId();
    }
}
