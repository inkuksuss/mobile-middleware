package com.middleware.mobile.web.exception.custom;

public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException() {}

    public BoardNotFoundException(String message) {
        super(message);
    }
}
