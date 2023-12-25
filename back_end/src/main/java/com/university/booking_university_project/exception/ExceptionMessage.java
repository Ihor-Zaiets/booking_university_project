package com.university.booking_university_project.exception;

public class ExceptionMessage {
    public static final String TRIM_VALIDATION_MESSAGE = "Napis zawiera białe znaki na początku lub końcu";
    public static final String USER_FIRSTNAME_DOES_NOT_MATCH_PATTERN = "Nieprawidłowy wzorzec imienia użytkownika";
    public static final String FIELD_NULL_OR_EMPTY_VALIDATION_MESSAGE = "Pole jest puste lub null";
    public static final String USER_SURNAME_VALIDATION_MESSAGE = "Nazwisko użytkownika jest puste lub null";
    public static final String EMAIL_VALIDATION_MESSAGE = "Adres e-mail nie spełnia wzorca";
    public static final String PHONE_NUMBER_VALIDATION_MESSAGE = "Numer telefonu nie spełnia wzorca";
    public static final String EMAIL_ALREADY_EXISTS_VALIDATION_MESSAGE = "Adres e-mail już istnieje";
    public static final String ROLE_ALREADY_EXISTS_VALIDATION_MESSAGE = "Rola już istnieje";
    public static final String PHONE_ALREADY_EXISTS_VALIDATION_MESSAGE = "Numer telefonu już istnieje";
    public static final String USER_NOT_FOUND_EXCEPTION = "Użytkownik nie został znaleziony";

    public static final String WRONG_NUMERIC_VALUE = "Nieprawidłowa wartość numeryczna";
    public static final String END_DATE_BEFORE_START_DATE = "Data końcowa jest przed datą początkową";
    public static final String RESERVATION_OVERLAY = "Rezerwacja dla tego hotelu w tym czasie już istnieje";
    public static final String START_DATE_OR_END_DATE_IS_NULL = "Data początkowa lub data końcowa jest pusta";
    public static final String START_DATE_EQUALS_END_DATE = "Data początkowa równa się dacie końcowej";
}
