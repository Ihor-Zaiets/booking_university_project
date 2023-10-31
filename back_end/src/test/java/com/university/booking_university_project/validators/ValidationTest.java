package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidationTest {

  @Test
  public void validateTrimSpacesThrowIfContains() {
    String beginning = " string";
    String end = "string ";
    String both = " string ";
    String multiple = "   string   ";

    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(beginning));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(end));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(both));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(multiple));
  }

  @Test
  public void validateTrimSpacesNotThrowIfDoesNotContains() {
    String string = "string";

    Assertions.assertDoesNotThrow(() -> Validation.validateTrimSpaces(string));
  }

  @Test
  public void validateUserFirstNameThrowIfUserFirstnameIsNullOrBlank() {
    String userFirstName = "";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(userFirstName));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(null));
  }

  @Test
  public void validateUserFirstNameNotThrowIfUserFirstnameIsNotNullOrBlank() {
    String userFirstName = "name";
    Assertions.assertDoesNotThrow(() -> Validation.validateUserFirstName(userFirstName));
  }

  @Test
  public void validateUserFirstnameThrowIfUserFirstNameContainsOnlyNumbers() {
    String userFirstName = "34598632";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(userFirstName));
  }

  @Test
  public void validateUserSurnameThrowIfUserSurnameNullOrBlank() {
    String userSurname = "";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(userSurname));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(null));
  }

  @Test
  public void validateUserSurnameNotThrowIfUserSurnameIsNotNullOrBlank() {
    String userSurname = "surname";
    Assertions.assertDoesNotThrow(() -> Validation.validateUserSurname(userSurname));
  }

  @Test
  public void validateUserSurnameThrowIfUserSurnameContainsOnlyNumbers() {
    String userSurname = "134667536432";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(userSurname));
  }

  @Test
  public void validateUserEmailDoNothingIfEmailIsNull() {
    Assertions.assertDoesNotThrow(() -> Validation.validateEmail(null));
  }

  @Test
  public void validateUserEmailThrowIfEmailDoesNotMatchPattern() {
    String emptyUserEmail = "";
    String justString = "string";
    String emailWithoutDomain= "string@string";
    String emailWithShortDomain= "string@str.ing.c";
    String emailWithoutAT= "string.string";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(emptyUserEmail));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(justString));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(emailWithoutDomain));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(emailWithShortDomain));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(emailWithoutAT));
  }

  @Test
  public void validateUserEmailNotThrowIfUserEmailMatchesPattern() {
    String exampleEmail = "example@email.com";
    String differentDomain = "domain@string.differentdomain";
    String withNumbers = "emailNr9000@gmail.yonk";
    String multipleDomains = "emailNr9000@gmail.gmail2.yonk";

    Assertions.assertDoesNotThrow(() -> Validation.validateEmail(exampleEmail));
    Assertions.assertDoesNotThrow(() -> Validation.validateEmail(differentDomain));
    Assertions.assertDoesNotThrow(() -> Validation.validateEmail(withNumbers));
    Assertions.assertDoesNotThrow(() -> Validation.validateEmail(multipleDomains));
  }

  @Test
  public void validateUserPhoneNotThrowIfUserPhoneMatchesPattern() {
    String userPhone = "123456789";
    String userPhoneWithCode = "+48123456789";
    String userPhoneWithSpaces = "123 456 78 9";
    Assertions.assertDoesNotThrow(() -> Validation.validatePhone(userPhone));
    Assertions.assertDoesNotThrow(() -> Validation.validatePhone(userPhoneWithCode));
    Assertions.assertDoesNotThrow(() -> Validation.validatePhone(userPhoneWithSpaces));
  }

  @Test
  public void validateUserPhoneThrowIfUserNumberPhoneDoesNotMatchPattern() {
    String empty = "";
    String string = "string";
    String stringWithNumbers = "+str1ngWith5624";
    String tooLong = "12345678900987654321";
    String tooShort = "12345";

    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(empty));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(string));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(stringWithNumbers));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(tooLong));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(tooShort));
  }
}
