package com.university.booking_university_project.configuration;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingUniversityProjectConfiguration {

  @Bean
  public DozerBeanMapper getDozerBeanMapper() {
    return (DozerBeanMapper) DozerBeanMapperBuilder.buildDefault();
  }
}
