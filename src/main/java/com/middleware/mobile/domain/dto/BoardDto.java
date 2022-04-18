package com.middleware.mobile.domain.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class BoardDto {

    private Long BoardId;
    private Long categoryId;
    private Long memberId;
    private String memberAlias;
    private String categoryName;
    private String boardTitle;
    private String boardBody;
    private Timestamp boardUpdated;
    private String boardStatus;
    private int boardScore;
    private int boardView;
    private int stateDel;
}
