package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter @Setter
public class CrackDto {
    private Long crackId;
    private Long memberId;
    private Long channelId;
    private String crackName;
    private Timestamp crackUpdated;
    private Timestamp crackCreated;
    private String crackStatus;
    private char stateDel;

}
