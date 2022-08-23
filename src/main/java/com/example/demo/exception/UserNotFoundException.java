package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception handler - returns 404
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }

}
