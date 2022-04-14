package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.MemberDto;


public interface MemberService {

    void addMember(MemberDto memberDto) throws Exception;

    MemberDto doLogin(MemberDto memberDto) throws Exception;
}
