package com.university.booking_university_project.modules.sender;

import jakarta.mail.MessagingException;

public interface EmailSenderService {
    void send(String to, String title, String content) throws MessagingException;
}
