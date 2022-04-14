package com.middleware.mobile.web.exception.custom;

public class PasswordNotCorrectException extends RuntimeException {

    public PasswordNotCorrectException() {}

    public PasswordNotCorrectException(String message) {
        super(message);
    }
}