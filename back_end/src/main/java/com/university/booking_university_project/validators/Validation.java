package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ExceptionMessage;
import com.university.booking_university_project.exception.ValidationException;

import java.util.Objects;

public class Validation {

  public static final String ONLY_NUMBERS_REGEX = "\\d+";
  public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  public static final String PHONE_REGEX = "^(\\+\\d{1,3}\\s*)?\\d{9}$";

  public static final String FIRSTNAME_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu imie.";
  public static final String SURTNAME_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu nazwisko.";
  public static final String EMAIL_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu email.";
  public static final String PHONE_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu telefon.";
  public static final String LOGIN_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu login.";
  public static final String PASSWORD_FIELD_EXCEPTION_MESSAGE_PREFIX = "Błąd w polu hasło.";

  public static void validateTrimSpaces(String string) {
    validateTrimSpaces(string, "");
  }

  /**
   * @param string string to check on trim spaces, if null then ignore.
   * */
  public static void validateTrimSpaces(String string, String prefix) {
    if (string != null && !string.trim().equals(string)) {
      throw new ValidationException(prefix + ExceptionMessage.TRIM_VALIDATION_MESSAGE);
    }
  }

  public static void validateObjectNullOrEmpty(Object object) {
    validateObjectNullOrEmpty(object, "");
  }

  public static void validateObjectNullOrEmpty(Object object, String prefix) {
    if (Objects.isNull(object) || object instanceof String && object.toString().isEmpty())
      throw new ValidationException(prefix + ExceptionMessage.FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE);
  }

  public static void validateUserFirstName(String firstName) {
    validateObjectNullOrEmpty(firstName, FIRSTNAME_FIELD_EXCEPTION_MESSAGE_PREFIX + " ");
    validateTrimSpaces(firstName, FIRSTNAME_FIELD_EXCEPTION_MESSAGE_PREFIX + " ");
    if (firstName.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException(ExceptionMessage.USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN);
  }

  public static void validateUserSurname(String userSurname) {
    validateTrimSpaces(userSurname, SURTNAME_FIELD_EXCEPTION_MESSAGE_PREFIX);
    if (userSurname != null && (userSurname.isBlank() || userSurname.matches(ONLY_NUMBERS_REGEX)))
      throw new ValidationException(ExceptionMessage.USER_SURNAME_VALIDATION_MESSAGE);
  }

  /**
   * @param userEmail checks email against email regex, if email is null then ignore.
   * */
  public static void validateEmail(String userEmail) {
    validateTrimSpaces(userEmail, EMAIL_FIELD_EXCEPTION_MESSAGE_PREFIX);
    if (userEmail != null && !userEmail.matches(EMAIL_REGEX))
      throw new ValidationException(ExceptionMessage.EMAIL_VALIDATION_MESSAGE);
  }

  public static void validatePhone(String userPhone) {
    validatePhoneWithMessagePrefix(userPhone, "");
  }

  public static void validatePhoneWithMessagePrefix(String userPhone, String prefix) {
    validateObjectNullOrEmpty(userPhone, prefix);
    validateTrimSpaces(userPhone, prefix);
    if (!userPhone.replaceAll(" ", "").matches(PHONE_REGEX))
      throw new ValidationException(ExceptionMessage.PHONE_NUMBER_VALIDATION_MESSAGE);
  }

  public static void validateNumberMoreThen0(Number number) {
    if (!(number.doubleValue() > 0))
      throw new ValidationException(ExceptionMessage.WRONG_NUMERIC_VALUE);
  }
  public static void validateNumberMoreOrEquals0(Number number) {
    if (!(number.doubleValue() >= 0))
      throw new ValidationException(ExceptionMessage.WRONG_NUMERIC_VALUE);
  }

}
