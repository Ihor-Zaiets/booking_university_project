package com.university.booking_university_project.modules.sender;

public interface EmailSenderService {
    void send(String to, String title, String content);
}
