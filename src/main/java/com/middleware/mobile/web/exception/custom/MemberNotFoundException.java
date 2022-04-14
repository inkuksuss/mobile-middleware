package com.middleware.mobile.web.exception.custom;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {}

    public MemberNotFoundException(String message) {
        super(message);
    }
}
