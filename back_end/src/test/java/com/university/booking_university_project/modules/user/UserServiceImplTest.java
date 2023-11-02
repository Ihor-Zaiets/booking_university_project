package com.university.booking_university_project.modules.user;

import com.university.booking_university_project.exception.ValidationException;
import com.university.booking_university_project.jpa.entity.User;
import com.university.booking_university_project.modules.baseService.BaseServiceTest;
import com.university.booking_university_project.modules.user.dto.UserCreationDTO;
import com.university.booking_university_project.modules.user.repository.UserRepository;
import com.university.booking_university_project.testUtils.TestUtils;
import com.university.booking_university_project.validators.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest implements BaseServiceTest<User, Integer, UserServiceImpl> {

  private final UserRepository userRepository;

  private final TestUtils testUtils;

  private final UserServiceImpl userServiceImpl;

  public static final String TEST_USER_NAME = "TEST_USER_NAME";
  public static final String TEST_USER_SURNAME = "TEST_USER_SURNAME";
  public static final String TEST_USER_EMAIL = "TEST_USER_EMAIL@email.com";
  public static final String TEST_USER_PHONE = "123456789";
  public static final String TEST_USER_PHONE_V2 = "987654321";
  public static final String TEST_USER_ADDRESS = "TEST_USER_ADDRESS";

  @Autowired
  public UserServiceImplTest(
      UserRepository userRepository, TestUtils testUtils, UserServiceImpl userServiceImpl) {
    this.userRepository = userRepository;
    this.testUtils = testUtils;
    this.userServiceImpl = userServiceImpl;
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

  @Test
  public void createUserThrowIfEmailAlreadyExists() {
    String variableVersion = "v2";
    userRepository.save(
        testUtils.createUserEntity(
            TEST_USER_NAME,
            TEST_USER_SURNAME,
            TEST_USER_EMAIL,
            TEST_USER_PHONE,
            TEST_USER_ADDRESS));

    UserCreationDTO userCreationDTO = new UserCreationDTO();
    userCreationDTO.setFirstname(TEST_USER_NAME + variableVersion);
    userCreationDTO.setSurname(TEST_USER_SURNAME + variableVersion);
    userCreationDTO.setEmail(TEST_USER_EMAIL);
    userCreationDTO.setPhone(TEST_USER_PHONE_V2);
    userCreationDTO.setAddress(TEST_USER_ADDRESS + variableVersion);

    Assertions.assertThrows(
        ValidationException.class,
        () -> userServiceImpl.createUser(userCreationDTO),
        Validation.EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE);
  }

  @Test
  public void createUserNotThrowIfFieldsDoesNotRepeats() {
    String variableVersion = "v2";
    userRepository.save(
        testUtils.createUserEntity(
            TEST_USER_NAME,
            TEST_USER_SURNAME,
            TEST_USER_EMAIL,
            TEST_USER_PHONE,
            TEST_USER_ADDRESS));

    UserCreationDTO userCreationDTO = new UserCreationDTO();
    userCreationDTO.setFirstname(TEST_USER_NAME + variableVersion);
    userCreationDTO.setSurname(TEST_USER_SURNAME + variableVersion);
    userCreationDTO.setEmail(TEST_USER_EMAIL + variableVersion);
    userCreationDTO.setPhone(TEST_USER_PHONE_V2);
    userCreationDTO.setAddress(TEST_USER_ADDRESS + variableVersion);

    Assertions.assertDoesNotThrow(() -> userServiceImpl.createUser(userCreationDTO));
  }

  @Test
  public void createUserThrowIfPhoneAlreadyExists() {
    String variableVersion = "v2";
    userRepository.save(
            testUtils.createUserEntity(
                    TEST_USER_NAME,
                    TEST_USER_SURNAME,
                    TEST_USER_EMAIL,
                    TEST_USER_PHONE,
                    TEST_USER_ADDRESS));

    UserCreationDTO userCreationDTO = new UserCreationDTO();
    userCreationDTO.setFirstname(TEST_USER_NAME + variableVersion);
    userCreationDTO.setSurname(TEST_USER_SURNAME + variableVersion);
    userCreationDTO.setEmail(TEST_USER_EMAIL + variableVersion);
    userCreationDTO.setPhone(TEST_USER_PHONE);
    userCreationDTO.setAddress(TEST_USER_ADDRESS + variableVersion);

    Assertions.assertThrows(
            ValidationException.class,
            () -> userServiceImpl.createUser(userCreationDTO),
            Validation.PHONE_ALREADY_EXISTS_VALIDATION_MESSAGE);
  }
}
