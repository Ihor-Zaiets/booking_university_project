package com.university.booking_university_project.configuration;

import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ResourceNotFoundException;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByLogin(username);
    if (user == null)
      throw new ResourceNotFoundException(ExceptionMessage.USER_NOT_FOUND_EXCEPTION);
    Set<GrantedAuthority> roles = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    return new org.springframework.security.core.userdetails.User(username, user.getPassword(), roles);
  }
}
