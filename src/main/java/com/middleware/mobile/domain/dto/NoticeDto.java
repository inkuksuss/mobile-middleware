package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter @Setter
public class NoticeDto {

    private Long noticeId;
    private Long memberId;
    private Long crackId;
    private String noticeBody;
    private Timestamp noticeCreated;
    private char stateDel;
}
