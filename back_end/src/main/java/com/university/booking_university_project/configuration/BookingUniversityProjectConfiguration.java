package com.university.booking_university_project.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class BookingUniversityProjectConfiguration {

  private final ConfigReader configReader;

  @Autowired
  public BookingUniversityProjectConfiguration(ConfigReader configReader) {
    this.configReader = configReader;
  }

  @Bean
  public Mapper dozerBeanMapper() {
    return DozerBeanMapperBuilder.buildDefault();
  }

  @Bean
  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername(configReader.getAppEmailLogin());
    mailSender.setPassword(configReader.getAppEmailPassword());

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }
}
