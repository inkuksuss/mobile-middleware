package com.middleware.mobile.web.service.admin;

import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
@Qualifier("adminMemberService")
public class AdminMemberServiceImpl implements MemberService {

    @Override
    public ResultResponse<Void> addMember(MemberDto memberDto) throws SQLException {}

    @Override
    public ResultResponse<SessionDto> doLogin(MemberDto memberDto) throws SQLException {
        return null;
    }
}
