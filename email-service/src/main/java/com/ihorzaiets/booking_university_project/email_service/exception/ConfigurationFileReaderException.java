package com.ihorzaiets.booking_university_project.email_service.exception;

public class ConfigurationFileReaderException extends RuntimeException {

    public ConfigurationFileReaderException(String fileName) {
        super("No such file found: " + fileName + ". Check if " + fileName + " exists in project resources.");
    }

    public ConfigurationFileReaderException(String propertyName, String fileName) {
        super("No " + propertyName + " property found in file: " + fileName);
    }
}
