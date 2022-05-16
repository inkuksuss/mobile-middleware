package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class WorkDto {
    private Long workId;
    private Long memberId;
    private Long checkerId;
    private Long crackId;
    private String workBody;
    private Timestamp workStart;
    private Timestamp workEnd;
    private Timestamp workCreated;
    private Timestamp workUpdated;
    private String workStatus;
    private char workType;
    private char stateDel;
}
