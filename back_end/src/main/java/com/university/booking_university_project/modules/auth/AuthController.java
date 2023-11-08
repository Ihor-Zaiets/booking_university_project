package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping("/signup")
  public ResponseEntity<Void> getResponseEntity(@RequestBody UserRegistrationRequest registrationRequest) {
    authService.signUp(registrationRequest);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
