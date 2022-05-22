package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class ParticipationDto {
    private Long memberId;
    private Long channelId;
    private Timestamp participationCreated;
    private Timestamp participationUpdated;
    private String participationAuthority;
    private char stateDel;

    private String memberAlias;
    private String memberEmail;
    private String memberStudentId;
    private String memberDepartment;
    private String memberAuthority;

    private Long loginMemberId;
}
