package com.ihorzaiets.booking_university_project.email_service.modules.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailEventListener {

    @Autowired
    private EmailSenderService emailSenderService;

    @Value("secret.application.email.login")
    private String applicationEmail;

    @KafkaListener(topics = "email", groupId = "email-service")
    public void handleEmailEvent(EmailEvent emailEvent) {
        if (emailEvent.from() == null)
            emailSenderService.sendEmail(applicationEmail, emailEvent.to(), emailEvent.subject(), emailEvent.content());
        else
            emailSenderService.sendEmail(emailEvent.from(), emailEvent.to(), emailEvent.subject(), emailEvent.content());
    }
}
