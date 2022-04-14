package com.middleware.mobile.domain.dto;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.common.Status;
import com.middleware.mobile.domain.request.AddMemberForm;
import com.middleware.mobile.domain.request.LoginForm;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class MemberDto {

    private Long memberId;
    private String memberName;
    private String memberEmail;
    private String memberStudentId;
    private short memberGrade;
    private String memberAlias;
    private String memberDepartment;
    private String memberPhone;
    private String memberStatus;
    private String memberBirthday;
    private Timestamp memberCreated;
    private Timestamp memberUpdated;
    private String memberPassword;
    private char memberAuthority;
    private char stateDel;

    private MemberDto() {}

    public static MemberDto from(AddMemberForm form) {
        MemberDto memberDto = new MemberDto();

        if (form.getMemberAuthority() == Authority.MEMBER.getValue()) {
            memberDto.memberAuthority = Authority.MEMBER.getValue();
        } else if (form.getMemberAuthority() == Authority.PROFESSOR.getValue()) {
            memberDto.memberAuthority = Authority.PROFESSOR.getValue();
        } else {
            memberDto.memberAuthority = Authority.ADMIN.getValue();
        }

        memberDto.memberName = form.getMemberName();
        memberDto.memberEmail = form.getMemberEmail();
        memberDto.memberStudentId = form.getMemberStudentId();
        memberDto.memberGrade = form.getMemberGrade();
        memberDto.memberAlias = form.getMemberAlias();
        memberDto.memberDepartment = form.getMemberDepartment();
        memberDto.memberPhone = form.getMemberPhone();
        memberDto.memberBirthday = form.getMemberBirthday();
        memberDto.memberPassword = form.getMemberPassword();
        memberDto.memberStatus = Status.ACTIVE.getValue();
        memberDto.memberAuthority = form.getMemberAuthority();
        memberDto.memberCreated = new Timestamp(System.currentTimeMillis());
        memberDto.memberUpdated = new Timestamp(System.currentTimeMillis());
        memberDto.stateDel = 'N';

        return memberDto;
    }

    public static MemberDto from(LoginForm form) {
        MemberDto memberDto = new MemberDto();

        memberDto.memberEmail = form.getMemberEmail();
        memberDto.memberPassword = form.getMemberPassword();

        return memberDto;
    }

    public static MemberDto removePassword(MemberDto member) {
        MemberDto memberDto = new MemberDto();

        memberDto.memberPassword = null;
        memberDto.memberName = member.getMemberName();
        memberDto.memberEmail = member.getMemberEmail();
        memberDto.memberStudentId = member.getMemberStudentId();
        memberDto.memberGrade = member.getMemberGrade();
        memberDto.memberAlias = member.getMemberAlias();
        memberDto.memberDepartment = member.getMemberDepartment();
        memberDto.memberPhone = member.getMemberPhone();
        memberDto.memberBirthday = member.getMemberBirthday();
        memberDto.memberStatus = member.getMemberStatus();
        memberDto.memberAuthority = member.getMemberAuthority();
        memberDto.memberCreated = member.getMemberCreated();
        memberDto.memberUpdated = member.getMemberUpdated();
        memberDto.stateDel = member.getStateDel();

        return memberDto;
    }
}
