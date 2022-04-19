package com.middleware.mobile.domain.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CategoryAssetDto {

    private Long BoardId;
    private String categoryName;
    private String boardTitle;
    private String boardBody;
    private Timestamp boardUpdated;
    private String boardStatus;
    private int boardScore;
    private int boardView;
    private int boardStateDel;

    private Long memberId;
    private short memberGrade;
    private String memberAlias;
    private String memberName;
    private String memberEmail;
    private String memberStudentId;
    private String memberDepartment;
    private String memberPhone;
    private String memberStatus;
    private String memberBirthday;
    private String memberPassword;
    private Timestamp memberCreated;
    private Timestamp memberUpdated;
    private char memberAuthority;
    private char memberStateDel;

    private Long categoryId;
    private Long categoryMemberId;
    private String categoryStatus;
    private Timestamp categoryCreated;
    private Timestamp categoryUpdated;
}
