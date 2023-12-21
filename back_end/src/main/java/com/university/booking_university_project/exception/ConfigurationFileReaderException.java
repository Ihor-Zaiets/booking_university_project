package com.university.booking_university_project.exception;

public class ConfigurationFileReaderException extends RuntimeException {

    public ConfigurationFileReaderException(String fileName) {
        super("No such file found: " + fileName);
    }

    public ConfigurationFileReaderException(String propertyName, String fileName) {
        super("No " + propertyName + " property found in file: " + fileName);
    }
}
