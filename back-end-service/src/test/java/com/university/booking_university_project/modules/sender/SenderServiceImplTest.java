package com.university.booking_university_project.modules.sender;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SenderServiceImplTest {

    @Autowired
    private SenderServiceImpl senderServiceImpl;

    @Test
    public void test() throws MessagingException {
        String emailTo = "hidden82.hidden82@gmail.com";
        String title = "Sender test";
        String content = "Test content for mail";
        assertDoesNotThrow(() -> senderServiceImpl.send(emailTo, title, content));
    }
}
