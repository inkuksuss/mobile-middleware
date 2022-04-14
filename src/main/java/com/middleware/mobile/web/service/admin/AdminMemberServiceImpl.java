package com.middleware.mobile.web.service.admin;

import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.web.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
@Qualifier("adminMemberService")
public class AdminMemberServiceImpl implements MemberService {

    @Override
    public void addMember(MemberDto memberDto) throws SQLException {

    }

    @Override
    public MemberDto doLogin(MemberDto memberDto) throws SQLException {
        return null;
    }
}
