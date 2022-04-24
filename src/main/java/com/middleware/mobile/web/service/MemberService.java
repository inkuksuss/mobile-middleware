package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface MemberService {

    ResultResponse<Void> addMember(MemberDto memberDto) throws Exception;

    ResultResponse<SessionDto> doLogin(MemberDto memberDto) throws Exception;
}
