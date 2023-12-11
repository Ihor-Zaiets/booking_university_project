package com.university.booking_university_project.modules.jwt;

import com.university.booking_university_project.jpa.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
  String extractUserName(String token);

  String generateToken(User user);

  boolean isTokenValid(String token, UserDetails userDetails);
}
