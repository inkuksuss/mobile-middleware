package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.domain.request.member.AddMemberForm;
import com.middleware.mobile.domain.request.member.LoginForm;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    public ResultResponse<String> doLogin(@RequestBody LoginForm form) throws Exception {
        MemberDto memberDto = MemberDto.from(form);

        return memberService.doLogin(memberDto);
    }

    @PostMapping("/join")
    public ResultResponse<Void> addMember(@RequestBody AddMemberForm form) throws Exception{
        MemberDto memberDto = MemberDto.from(form);

        return memberService.addMember(memberDto);
    }
}
