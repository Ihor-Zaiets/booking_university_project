package com.university.booking_university_project.modules.role.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Setter
@Getter
public class RoleUpdateDTO {

    private Integer id;

    @NonNull
    private String name;

    private String description;
}
