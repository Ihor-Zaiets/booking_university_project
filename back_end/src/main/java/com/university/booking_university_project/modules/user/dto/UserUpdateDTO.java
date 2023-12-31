package com.university.booking_university_project.modules.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class UserUpdateDTO {

    private Integer id;

    private String login;

    @NonNull
    private String firstname;

    private String surname;

    private String email;

    @NonNull
    private String phone;

    private String address;
}
