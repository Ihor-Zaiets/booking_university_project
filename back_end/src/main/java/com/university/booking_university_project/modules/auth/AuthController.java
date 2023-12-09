package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.security.SecurityService;
import com.university.booking_university_project.modules.user.UserService;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.dto.UserRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/signup")
  public ResponseEntity<UserDTO> getResponseEntity(@RequestBody UserRegistrationRequest registrationRequest) {
    return ResponseEntity.ok(authService.signUp(registrationRequest));
  }

  @GetMapping("/loggedUser")
  public UserDTO getLoggedUser() {
    return authService.getLoggedUserDTO();
  }
}
