package com.university.booking_university_project.modules.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class UserLoginRequest {

    @NonNull
    private String login;
    @NonNull
    private String password;
}
