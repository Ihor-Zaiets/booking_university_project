package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.user.UserServiceImpl;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;
import com.university.booking_university_project.validators.Validation;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserServiceImpl userServiceImpl;

  public AuthServiceImpl(UserServiceImpl userServiceImpl) {
    this.userServiceImpl = userServiceImpl;
  }

  @Override
  public UserDTO signUp(UserRegistrationRequest registrationRequest) {
    validateUser(registrationRequest);
    return userServiceImpl.signUp(registrationRequest);
  }

  private void validateUser(UserRegistrationRequest userRegistrationRequest) {
    Validation.validateUserFirstName(userRegistrationRequest.getFirstname());
    Validation.validateUserSurname(userRegistrationRequest.getSurname());
    Validation.validateEmail(userRegistrationRequest.getEmail());
    userServiceImpl.validateEmailAlreadyExist(userRegistrationRequest.getEmail());
    Validation.validatePhone(userRegistrationRequest.getPhone());
    validateLogin(userRegistrationRequest.getLogin());
    validatePassword(userRegistrationRequest.getPassword());
  }

  private void validatePassword(String password) {
    Validation.validateObjectNullOrEmpty(password);
    Validation.validateTrimSpaces(password);
  }

  private void validateLogin(String login) {
    Validation.validateObjectNullOrEmpty(login);
    Validation.validateTrimSpaces(login);
  }
}
