package com.middleware.mobile.web.exception.custom;

public class MemberDuplicatedException extends RuntimeException {

    public MemberDuplicatedException() {}

    public MemberDuplicatedException(String message) {
        super(message);
    }
}
