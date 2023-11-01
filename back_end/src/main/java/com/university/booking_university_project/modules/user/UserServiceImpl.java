package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.EntityService;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends EntityService<User, Integer, UserRepository> implements UserService {



  public String testMethod() {
    return "Test string";
  }
}
