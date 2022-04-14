package com.middleware.mobile.domain.response;


import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(0, "SUCCESS"),

    PAGE_NOT_FOUND(9001, "PAGE_NOT_FOUND"),
    DENIED(9002, "DENIED"),
    FORBIDDEN(9003, "FORBIDDEN"),
    FAIL(9004, "FAIL"),
    DB_ERROR(9005, "DB_ERROR"),
    INTERVAL_SERVER_ERROR(9006, "ERROR"),

    UNAUTHORIZED(8001, "UNAUTHORIZED"),
    MEMBER_NOT_FOUND(8002, "MEMBER_NOT_FOUND"),
    MEMBER_DUPLICATED(8003, "MEMBER_DUPLICATED"),
    PASSWORD_NOT_CORRECT(8004, "PASSWORD_NOT_CORRECT"),

    INVALID_PARAMETER(7001, "INVALID_PARAMETER");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
