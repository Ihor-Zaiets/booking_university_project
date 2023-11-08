package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;

public interface AuthService {
  void signUp(UserRegistrationRequest userRegistrationRequest);
}
