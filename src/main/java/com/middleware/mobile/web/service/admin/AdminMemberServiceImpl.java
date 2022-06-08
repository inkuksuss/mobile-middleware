package com.middleware.mobile.web.service.admin;

import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;


@Service
@Qualifier("adminMemberService")
public class AdminMemberServiceImpl implements MemberService {

    @Override
    public ResultResponse<Void> addMember(MemberDto memberDto) throws SQLException {
        return null;
    }

    @Override
    public ResultResponse<String> doLogin(MemberDto memberDto) throws SQLException {
        return null;
    }

    @Override
    public boolean getLoginUser(HttpServletRequest request) throws Exception {
        return false;
    }

    @Override
    public Long getLoginUserId(HttpServletRequest request) throws Exception {
        return null;
    }
}
