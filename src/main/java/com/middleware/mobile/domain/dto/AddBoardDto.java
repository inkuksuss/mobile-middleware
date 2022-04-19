package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class AddBoardDto {
    private Long boardId;
    private Long memberId;
    private Long categoryId;
    private String boardTitle;
    private String boardBody;
    private String boardStatus;
    private Timestamp boardCreated;
    private Timestamp boardUpdated;
    private int boardScore;
    private int boardView;
    private char stateDel;
}
