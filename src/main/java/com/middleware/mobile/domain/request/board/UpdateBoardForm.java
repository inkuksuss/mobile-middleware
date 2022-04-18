package com.middleware.mobile.domain.request.board;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UpdateBoardForm {
    private Long categoryId;
    private String boardTitle;
    private String boardBody;
    private String boardStatus;
    private Timestamp boardUpdated;
}
