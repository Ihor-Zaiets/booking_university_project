package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest implements BaseServiceTest<User, Integer, UserServiceImpl> {

  private final UserRepository userRepository;

  private static final String TEST_USER_NAME = "TEST_USER_NAME";
  private static final String TEST_USER_SURNAME = "TEST_USER_SURNAME";
  private static final String TEST_USER_EMAIL = "TEST_USER_EMAIL@email.com";
  private static final String TEST_USER_PHONE = "123456789";
  private static final String TEST_USER_ADDRESS = "TEST_USER_ADDRESS";

  @Autowired
  public UserServiceImplTest(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Autowired
  public UserServiceImpl createService() {
    return new UserServiceImpl(userRepository);
  }

  @Override
  public User createEntity() {
    User user = new User();
    user.setName(TEST_USER_NAME);
    user.setSurname(TEST_USER_SURNAME);
    user.setEmail(TEST_USER_EMAIL);
    user.setPhone(TEST_USER_PHONE);
    user.setAddress(TEST_USER_ADDRESS);
    return user;
  }
}
