package com.university.booking_university_project.exception;

public class ValidationException extends RuntimeException {
    public ValidationException() {
        super("Validation exception");
    }

    public ValidationException(String message) {
        super(message);
    }
}
