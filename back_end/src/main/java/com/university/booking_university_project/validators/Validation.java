package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;

public class Validation {

  public static final String ONLY_NUMBERS_REGEX = "\\d+";
  public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  public static final String PHONE_REGEX = "^(\\+\\d{1,3}\\s*)?\\d{9}$";

  /**
   * @param string string to check on trim spaces, if null then ignore.
   * */
  public static void validateTrimSpaces(String string) {
    if (string != null && !string.trim().equals(string)) {
      throw new ValidationException(ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    }
  }

  public static void validateStringNullOrEmpty(String string) {
    if (string == null || string.isEmpty())
      throw new ValidationException(ExceptionMessage.STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  public static void validateUserFirstName(String firstName) {
    validateStringNullOrEmpty(firstName);
    validateTrimSpaces(firstName);
    if (firstName.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException(ExceptionMessage.USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN);
  }

  public static void validateUserSurname(String userSurname) {
    validateTrimSpaces(userSurname);
    if (userSurname != null && (userSurname.isBlank() || userSurname.matches(ONLY_NUMBERS_REGEX)))
      throw new ValidationException(ExceptionMessage.USER_SURNAME_VALIDATION_MESSAGE);
  }

  /**
   * @param userEmail checks email against email regex, if email is null then ignore.
   * */
  public static void validateEmail(String userEmail) {
    validateTrimSpaces(userEmail);
    if (userEmail != null && !userEmail.matches(EMAIL_REGEX))
      throw new ValidationException(ExceptionMessage.EMAIL_VALIDATION_MESSAGE);
  }

  public static void validatePhone(String userPhone) {
    validateStringNullOrEmpty(userPhone);
    validateTrimSpaces(userPhone);
    if (!userPhone.replaceAll(" ", "").matches(PHONE_REGEX))
      throw new ValidationException(ExceptionMessage.PHONE_NUMBER_VALIDATION_MESSAGE);
  }
}
