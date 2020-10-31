package com.meru.offerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomMessageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails customMessageException(CustomMessageException ex) {
        return new CustomErrorDetails();
    }
}
