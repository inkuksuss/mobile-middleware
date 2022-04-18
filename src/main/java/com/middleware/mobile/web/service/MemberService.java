package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface MemberService {

    void addMember(MemberDto memberDto) throws Exception;

    MemberDto doLogin(MemberDto memberDto) throws Exception;
}
