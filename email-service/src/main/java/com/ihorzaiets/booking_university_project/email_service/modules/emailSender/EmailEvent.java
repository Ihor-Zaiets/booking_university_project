package com.ihorzaiets.booking_university_project.email_service.modules.emailSender;

public record EmailEvent(String from, String to, String subject, String content) {}
