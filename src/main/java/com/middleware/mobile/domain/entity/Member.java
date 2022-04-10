package com.middleware.mobile.domain.entity;


import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.common.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long memberId;

    private String memberName;
    private String memberStudentId;
    private char memberGrade;
    private String memberAlias;
    private String memberDepartment;
    private String memberPhone;
    private String memberStatus;
    private Timestamp memberCreated;
    private Timestamp memberBirthday;
    private Timestamp memberUpdated;
    private String memberPassword;
    private char memberAuthority;
    private char stateDel;
}
