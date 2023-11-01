package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.EntityService;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.testUtils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

  private final UserRepository userRepository;

  private final TestUtils testUtils;

  private final UserServiceImpl userServiceImpl;

  @Autowired
  private EntityService<User, Integer, UserRepository> entityService;

  public static final String TEST_USER_NAME = "TEST_USER_NAME";
  public static final String TEST_USER_SURNAME = "TEST_USER_SURNAME";
  public static final String TEST_USER_EMAIL = "TEST_USER_EMAIL@email.com";
  public static final String TEST_USER_PHONE = "123456789";
  public static final String TEST_USER_ADDRESS = "TEST_USER_ADDRESS";

  @Autowired
  public UserServiceImplTest(UserRepository userRepository, TestUtils testUtils, UserServiceImpl userServiceImpl) {
    this.userRepository = userRepository;
    this.testUtils = testUtils;
    this.userServiceImpl = userServiceImpl;
  }

  @Test
  public void createUserTest() {
    System.out.println(userServiceImpl.testMethod());
    entityService.findById(0);
  }
}
