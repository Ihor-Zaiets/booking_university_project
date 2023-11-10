package com.university.booking_university_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBodyExceptionDetails {

  private Integer status;
  private Date timestamp;
  private String message;
  private String trace;

  public ResponseBodyExceptionDetails(HttpStatus status, Date timestamp, String message) {
    this.status = status.value();
    this.timestamp = timestamp;
    this.message = message;
  }

  public ResponseBodyExceptionDetails(HttpStatus status, String message, String trace) {
    this.status = status.value();
    this.timestamp = new Date();
    this.message = message;
    this.trace = trace;
  }

  public ResponseBodyExceptionDetails(HttpStatus status, String message) {
    this.status = status.value();
    this.timestamp = new Date();
    this.message = message;
  }
}
