package com.university.booking_university_project.exception;

public class ExceptionMessage {
  public static final String TRIM_VALIDATION_MESSAGE = "String contains white spaces at beginning or end";
  public static final String USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN = "User firstname bad pattern";
  public static final String FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE = "Field is null or empty";
  public static final String USER_SURNAME_VALIDATION_MESSAGE = "User surname is null or empty";
  public static final String EMAIL_VALIDATION_MESSAGE = "Email does not match pattern";
  public static final String PHONE_NUMBER_VALIDATION_MESSAGE = "Phone number does not match pattern";
  public static final String EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE = "Email already exists";
  public static final String ROLE_ALREADY_EXISTS_VALIDATION_MESSAGE = "Role already exists";
  public static final String PHONE_ALREADY_EXISTS_VALIDATION_MESSAGE = "Phone number already exists";
  public static final String USER_NOT_FOUND_EXCEPTION = "User not found";

  public static final String WRONG_NUMERIC_VALUE = "Wrong numeric value";
  public static final String END_DATE_BEFORE_START_DATE = "End date is before start date";
  public static final String RESERVATION_OVERLAY = "Reservation for that hotel in that time already exists";
}
