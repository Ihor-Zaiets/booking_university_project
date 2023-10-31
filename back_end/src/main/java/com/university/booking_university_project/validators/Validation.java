package com.university.booking_university_project.validators;

import com.university.booking_university_project.exception.ValidationException;

public class Validation {

  public final static String ONLY_NUMBERS_REGEX = "\\d+";
  public final static String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
  public final static String PHONE_REGEX = "^(\\+\\d{1,3}\\s*)?\\d{9}$";

  public static void validateTrimSpaces(String string) {
    if (!string.trim().equals(string))
      throw new ValidationException("String contains white spaces at beginning or end");
  }

  public static void validateUserFirstName(String firstName) {
    if (firstName == null || firstName.isBlank() || firstName.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException("User firstname is null or empty");
  }

  public static void validateUserSurname(String userSurname) {
    if (userSurname == null || userSurname.isBlank() || userSurname.matches(ONLY_NUMBERS_REGEX))
      throw new ValidationException("User surname is null or empty");
  }

  public static void validateEmail(String userEmail) {
    if (userEmail != null && !userEmail.matches(EMAIL_REGEX))
      throw new ValidationException("Email does not match pattern");
  }

  public static void validatePhone(String userPhone) {
    if (!userPhone.replaceAll(" ", "").matches(PHONE_REGEX))
      throw new ValidationException("Phone number does not match pattern");
  }
}
