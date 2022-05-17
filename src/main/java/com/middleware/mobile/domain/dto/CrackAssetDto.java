package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class CrackAssetDto {

    private Long crackId;
    private Long memberId;
    private Long channelId;
    private String crackName;
    private Timestamp crackUpdated;
    private Timestamp crackCreated;
    private String crackStatus;
    private char stateDel;

    private Long workId;
    private Long checkerId;
    private String workBody;
    private Timestamp workStart;
    private Timestamp workEnd;
    private Timestamp workCreated;
    private Timestamp workUpdated;
    private String workStatus;
    private char workType;

    private Long noticeId;
    private String noticeBody;
    private Timestamp noticeCreated;
}
