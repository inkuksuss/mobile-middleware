package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.request.member.AddMemberForm;
import com.middleware.mobile.domain.request.member.LoginForm;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public ResultResponse<Void> doLogin(@RequestBody LoginForm form, HttpSession httpSession) throws Exception {
        MemberDto memberDto = MemberDto.from(form);

        ResultResponse<SessionDto> response = memberService.doLogin(memberDto);
        httpSession.setAttribute(Authority.MEMBER.name(), response.getData());

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    @PostMapping("/join")
    public ResultResponse<Void> addMember(@RequestBody AddMemberForm form) throws Exception {
        MemberDto memberDto = MemberDto.from(form);

        return memberService.addMember(memberDto);
    }
}
