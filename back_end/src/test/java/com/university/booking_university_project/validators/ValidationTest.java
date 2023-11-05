package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ExceptionMessage;
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
    String whiteSpaces = "      ";

    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(beginning), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(end), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(both), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(multiple), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateTrimSpaces(whiteSpaces), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
  }

  @Test
  public void validateStringIsNullOrEmptyThrowIfItIs() {
    String empty = "";

    Assertions.assertThrows(ValidationException.class, () -> Validation.validateStringNullOrEmpty(empty), ExceptionMessage.STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateStringNullOrEmpty(null), ExceptionMessage.STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  @Test
  public void validateStringIsNullOrEmptyNotThrowIfItIsNot() {
    String string = "string";

    Assertions.assertDoesNotThrow(() -> Validation.validateStringNullOrEmpty(string));
  }

  @Test
  public void everyValidationShouldThrowIfStringContainsTrimSpaces() {
    String string = " string ";

    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(string), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(string), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateEmail(string), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validatePhone(string), ExceptionMessage.TRIM_VALIDATION_MESSAGE);
  }

  @Test
  public void validateTrimSpacesNotThrowIfDoesNotContains() {
    String string = "string";
    String empty = "";

    Assertions.assertDoesNotThrow(() -> Validation.validateTrimSpaces(string));
    Assertions.assertDoesNotThrow(() -> Validation.validateTrimSpaces(empty));
  }

  @Test
  public void validateUserFirstNameThrowIfUserFirstnameIsNullOrEmpty() {
    String userFirstName = "";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(userFirstName), ExceptionMessage.STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(null), ExceptionMessage.STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  @Test
  public void validateUserFirstNameNotThrowIfUserFirstnameIsNotNullOrEmpty() {
    String userFirstName = "name";
    Assertions.assertDoesNotThrow(() -> Validation.validateUserFirstName(userFirstName));
  }

  @Test
  public void validateUserFirstnameThrowIfUserFirstNameContainsOnlyNumbers() {
    String userFirstName = "34598632";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserFirstName(userFirstName), ExceptionMessage.USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN);
  }

  @Test
  public void validateUserSurnameThrowIfUserSurnameNullOrEmpty() {
    String userSurname = "";
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(userSurname));
    Assertions.assertThrows(ValidationException.class, () -> Validation.validateUserSurname(null));
  }

  @Test
  public void validateUserSurnameNotThrowIfUserSurnameIsNotNullOrEmpty() {
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
