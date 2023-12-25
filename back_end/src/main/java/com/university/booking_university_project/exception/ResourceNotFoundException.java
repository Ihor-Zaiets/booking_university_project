package com.university.booking_university_project.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Zasobu nie znaleziono.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
