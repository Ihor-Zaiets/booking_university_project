package com.university.booking_university_project.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ResponseBodyExceptionDetails> handleValidationException(ValidationException validationException) {
    return makeResponse(
            HttpStatus.CONFLICT,
            validationException.getMessage(),
            validationException
    );
  }

  private ResponseEntity<ResponseBodyExceptionDetails> makeResponse(HttpStatus status, String message, Exception exception) {
    ResponseBodyExceptionDetails details;
    String stackTrace = stackTraceAsString(exception);

    details = new ResponseBodyExceptionDetails(status, message, stackTrace);
    log.error(message, exception);

    return new ResponseEntity<>(details, status);
  }

  public static String stackTraceAsString(Throwable exception) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintWriter printWriter = new PrintWriter(outputStream);
    exception.printStackTrace(printWriter);
    printWriter.close();
    try {
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return outputStream.toString(StandardCharsets.UTF_8);
  }
}
