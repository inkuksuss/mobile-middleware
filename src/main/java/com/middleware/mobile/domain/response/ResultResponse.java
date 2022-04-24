package com.middleware.mobile.domain.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ResultResponse<T> {

    private HttpStatus httpStatus;
    private int resultCode;
    private int totalCount;
    private String resultMessage;
    private T data;

    public ResultResponse(HttpStatus httpStatus, int resultCode, String resultMessage) {
        this(httpStatus, resultCode, resultMessage, 0, null);
    }

    public ResultResponse(HttpStatus httpStatus, int resultCode, String resultMessage, T data) {
        this(httpStatus, resultCode, resultMessage, 0, data);
    }

    public ResultResponse(HttpStatus httpStatus, int resultCode, String resultMessage, int totalCount, T data) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.totalCount = totalCount;
        this.data = data;
    }
}
