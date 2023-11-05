package com.university.booking_university_project.modules.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @GetMapping("/testString")
  public String getSome() {
    return "some string";
  }

  @GetMapping("/testResponse")
  public ResponseEntity<String> getResponseEntity() {
    return ResponseEntity.ok("string");
  }
}
