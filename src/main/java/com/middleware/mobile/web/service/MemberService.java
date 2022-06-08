package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.domain.response.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface MemberService {

    ResultResponse<Void> addMember(MemberDto memberDto) throws Exception;

    ResultResponse<String> doLogin(MemberDto memberDto) throws Exception;

    boolean getLoginUser(HttpServletRequest request) throws Exception;

    Long getLoginUserId(HttpServletRequest request) throws Exception;
}
