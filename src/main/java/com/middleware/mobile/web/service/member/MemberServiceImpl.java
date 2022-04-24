package com.middleware.mobile.web.service.member;


import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.MemberDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.exception.custom.MemberDuplicatedException;
import com.middleware.mobile.web.exception.custom.MemberNotFoundException;
import com.middleware.mobile.web.exception.custom.PasswordNotCorrectException;
import com.middleware.mobile.web.repository.MemberRepository;
import com.middleware.mobile.web.common.PasswordEncoder;
import com.middleware.mobile.web.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Primary
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public ResultResponse<SessionDto> doLogin(MemberDto memberDto) throws Exception {

        MemberDto findMember = memberRepository.findMemberByEmail(memberDto.getMemberEmail())
                .orElseThrow(() -> new MemberNotFoundException("이메일을 확인해주세요."));

        String memberPassword = findMember.getMemberPassword();

        if (memberDto.getMemberPassword().equals(PasswordEncoder.decrypt(memberPassword))) {
            MemberDto member = MemberDto.removePassword(findMember);

            SessionDto sessionDto = SessionDto.builder()
                    .memberId(member.getMemberId())
                    .memberName(member.getMemberName())
                    .memberEmail(member.getMemberEmail())
                    .memberAuthority(member.getMemberAuthority())
                    .build();

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), sessionDto);
        } else {
            throw new PasswordNotCorrectException("비밀번호를 확인 해주세요.");
        }
    }

    @Override
    public ResultResponse<Void> addMember(MemberDto memberDto) throws Exception {

        boolean duplicatedMember = memberRepository.findMemberByEmail(memberDto.getMemberEmail()).isPresent();

        if (duplicatedMember) {
            throw new MemberDuplicatedException("이미 가입된 이메일입니다.");
        } else {
            memberDto.setMemberPassword(PasswordEncoder.encrypt(memberDto.getMemberPassword()));
            memberRepository.addMember(memberDto);

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
        }
    }
}
