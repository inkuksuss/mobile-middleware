package com.middleware.mobile.web.exception;


import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.exception.custom.MemberDuplicatedException;
import com.middleware.mobile.web.exception.custom.MemberNotFoundException;
import com.middleware.mobile.web.exception.custom.PasswordNotCorrectException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;


@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IllegalStateException.class)
    public ResultResponse forbiddenExHandle(IllegalStateException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.FORBIDDEN, ResultCode.FORBIDDEN.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccessDeniedException.class)
    public ResultResponse accessDeniedExHandle(AccessDeniedException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.BAD_REQUEST, ResultCode.DENIED.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultResponse illegalExHandle(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.BAD_REQUEST, ResultCode.INVALID_PARAMETER.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultResponse methodArgsNotNullExHandle(MethodArgumentNotValidException e) {
        log.error("[exceptionHandle] ex", e);
        String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResultResponse(HttpStatus.BAD_REQUEST, ResultCode.INVALID_PARAMETER.getCode(), errorMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    public ResultResponse sqlExHandle(SQLException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.BAD_REQUEST, ResultCode.DB_ERROR.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResultResponse notFoundExHandle(NotFoundException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.NOT_FOUND, ResultCode.PAGE_NOT_FOUND.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MemberDuplicatedException.class)
    public ResultResponse memberDuplicatedExHandle(MemberDuplicatedException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.OK, ResultCode.MEMBER_DUPLICATED.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MemberNotFoundException.class)
    public ResultResponse<Void> memberNotFoundExHandle(MemberNotFoundException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.OK, ResultCode.MEMBER_NOT_FOUND.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(PasswordNotCorrectException.class)
    public ResultResponse passwordNotCorrectExHandle(PasswordNotCorrectException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.OK, ResultCode.PASSWORD_NOT_CORRECT.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResultResponse runTimeExHandle(RuntimeException e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultResponse exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.INTERVAL_SERVER_ERROR.getCode(), e.getMessage());
    }
}
