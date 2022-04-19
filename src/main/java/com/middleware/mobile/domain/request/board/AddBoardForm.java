package com.middleware.mobile.domain.request.board;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class AddBoardForm {
    private String boardTitle;
    private String boardBody;
    private String boardStatus;
    private Long categoryId;
}
