package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ValidationException;

public class Validation {

  public static final String ONLY_NUMBERS_REGEX = "\\d+";
  public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  public static final String PHONE_REGEX = "^(\\+\\d{1,3}\\s*)?\\d{9}$";

  public static final String TRIM_VALIDATION_MESSAGE = "String contains white spaces at beginning or end";
  public static final String USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN = "User firstname bad pattern";
  public static final String STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE = "String is null or empty";
  public static final String USER_SURNAME_VALIDATION_MESSAGE = "User surname is null or empty";
  public static final String EMAIL_VALIDATION_MESSAGE = "Email does not match pattern";
  public static final String PHONE_NUMBER_VALIDATION_MESSAGE = "Phone number does not match pattern";
  public static final String EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE = "Email already exists";
  public static final String PHONE_ALREADY_EXISTS_VALIDATION_MESSAGE = "Phone number already exists";

  /**
   * @param string string to check on trim spaces, if null then ignore.
   * */
  public static void validateTrimSpaces(String string) {
    if (string != null && !string.trim().equals(string)) {
      throw new ValidationException(TRIM_VALIDATION_MESSAGE);
    }
  }

  public static void validateStringNullOrEmpty(String string) {
    if (string == null || string.isEmpty())
      throw new ValidationException(STRING_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  public static void validateUserFirstName(String firstName) {
    validateTrimSpaces(firstName);
    validateStringNullOrEmpty(firstName);
    if (firstName.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException(USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN);
  }

  public static void validateUserSurname(String userSurname) {
    validateTrimSpaces(userSurname);
    if (userSurname == null || userSurname.isBlank() || userSurname.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException(USER_SURNAME_VALIDATION_MESSAGE);
  }

  /**
   * @param userEmail checks email against email regex, if email is null then ignore.
   * */
  public static void validateEmail(String userEmail) {
    validateTrimSpaces(userEmail);
    if (userEmail != null && !userEmail.matches(EMAIL_REGEX))
      throw new ValidationException(EMAIL_VALIDATION_MESSAGE);
  }

  public static void validatePhone(String userPhone) {
    validateTrimSpaces(userPhone);
    if (!userPhone.replaceAll(" ", "").matches(PHONE_REGEX))
      throw new ValidationException(PHONE_NUMBER_VALIDATION_MESSAGE);
  }
}
