package com.university.booking_university_project.modules.sender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public SenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String to, String title, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper mailSend = new MimeMessageHelper(mail);
        try {
            mailSend.setTo(to);
            mailSend.setFrom(to);
            mailSend.setSubject(title);
            mailSend.setText(content);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mail);
    }
}
