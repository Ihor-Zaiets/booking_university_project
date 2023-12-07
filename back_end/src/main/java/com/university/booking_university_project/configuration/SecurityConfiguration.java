package com.university.booking_university_project.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests((authorize) ->
            authorize
                    .requestMatchers("/api/User/searchAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/User/createAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/User/editAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/User/deleteAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/Apartment/searchAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/Apartment/createAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/Apartment/editAll").hasAnyAuthority("ADMIN")
                    .requestMatchers("/api/Apartment/deleteAll").hasAnyAuthority("ADMIN")
                    .anyRequest().permitAll())
//            .httpBasic(Customizer.withDefaults()) //  turn on for postman testing
            .formLogin(formConfigurer ->
                    formConfigurer
                            .defaultSuccessUrl("/start")
                            .permitAll());

    return httpSecurity.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:4200", "*"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "HEAD", "DELETE", "PATCH", "OPTIONS", "CONNECT", "*"));
    configuration.setAllowedHeaders(List.of("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
