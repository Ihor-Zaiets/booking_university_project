package com.university.booking_university_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.csrf().disable().authorizeHttpRequests((authorize) ->
            authorize
                    .requestMatchers("/auth/testString").authenticated()
                    .anyRequest().permitAll())
//            .httpBasic(Customizer.withDefaults()) //  turn on for postman testing
            .formLogin(Customizer.withDefaults());

    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
