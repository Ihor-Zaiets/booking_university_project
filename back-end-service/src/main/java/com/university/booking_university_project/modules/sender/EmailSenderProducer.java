package com.university.booking_university_project.modules.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderProducer {

    private final KafkaTemplate<String, EmailEvent> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(EmailSenderProducer.class);

    @Autowired
    public EmailSenderProducer(KafkaTemplate<String, EmailEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmailEvent(EmailEvent emailEvent) {
        kafkaTemplate.send("email", emailEvent);
        log.info("""
                Sending EmailEvent to kafka.
                Topic: {}
                event: {}
                """, "email", emailEvent);
    }
}
