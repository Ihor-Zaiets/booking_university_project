package com.university.booking_university_project.modules.sender;

public record EmailEvent(String to, String subject, String content) {}
