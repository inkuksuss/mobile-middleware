package com.middleware.mobile.domain.request;


import lombok.Getter;


@Getter
public class AddMemberForm {

    private String memberName;
    private String memberEmail;
    private String memberStudentId;
    private String memberAlias;
    private String memberDepartment;
    private String memberPhone;
    private String memberBirthday;
    private String memberPassword;
    private short memberGrade;
    private char memberAuthority;
}
