package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.testUtils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest implements BaseServiceTest<User, Integer, UserServiceImpl> {

  private final UserRepository userRepository;

  private final TestUtils testUtils;

  public static final String TEST_USER_NAME = "TEST_USER_NAME";
  public static final String TEST_USER_SURNAME = "TEST_USER_SURNAME";
  public static final String TEST_USER_EMAIL = "TEST_USER_EMAIL@email.com";
  public static final String TEST_USER_PHONE = "123456789";
  public static final String TEST_USER_ADDRESS = "TEST_USER_ADDRESS";

  @Autowired
  public UserServiceImplTest(UserRepository userRepository, TestUtils testUtils) {
    this.userRepository = userRepository;
    this.testUtils = testUtils;
  }

  @Override
  @Autowired
  public UserServiceImpl createService() {
    return new UserServiceImpl(userRepository);
  }

  @Override
  public User createEntity() {
    return testUtils.createUserEntity(
        TEST_USER_NAME, TEST_USER_SURNAME, TEST_USER_EMAIL, TEST_USER_PHONE, TEST_USER_ADDRESS);
  }
}
