package com.university.booking_university_project.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingUniversityProjectConfiguration {

  @Bean
  public Mapper getDozerBeanMapper() {
    return DozerBeanMapperBuilder.buildDefault();
  }
}
