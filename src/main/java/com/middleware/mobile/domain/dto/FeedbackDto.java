package com.middleware.mobile.domain.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class FeedbackDto {

    private Long feedbackId;
    private Long workId;
    private Long memberId;
    private String feedbackBody;
    private Timestamp feedbackCreated;
    private Timestamp feedbackUpdated;
    private String feedbackStatus;
    private char stateDel;
}
