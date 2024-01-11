package com.university.booking_university_project.modules.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {

    private String login;

    private String password;

    private String firstname;

    private String surname;

    private String email;

    private String phone;

    private String address;
}
