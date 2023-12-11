package com.university.booking_university_project.modules.auth;

import com.university.booking_university_project.modules.jwt.dto.JwtAuthenticationResponse;
import com.university.booking_university_project.modules.user.dto.UserDTO;
import com.university.booking_university_project.modules.user.dto.UserLoginRequest;
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
  public ResponseEntity<UserDTO> signUp(@RequestBody UserRegistrationRequest registrationRequest) {
    return ResponseEntity.ok(authService.signUp(registrationRequest));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
    return ResponseEntity.ok(authService.login(userLoginRequest));
  }

  @GetMapping("/loggedUser")
  public UserDTO getLoggedUser() {
    return authService.getLoggedUserDTO();
  }
}
