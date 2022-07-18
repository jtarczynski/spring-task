package com.deloitte.carApp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ErrorInfo> handleException(AppException exception) {
        HttpStatus httpStatus = exception.getError().getHttpStatus();
        String message = exception.getError().getMessage();

        log.warn(exception.getError().getMessage());

        if (message != null) {
            return ResponseEntity.status(httpStatus)
                    .body(new ErrorInfo(exception.getError().getMessage()));
        } else {
            return ResponseEntity.status(httpStatus).build();
        }
    }
}
