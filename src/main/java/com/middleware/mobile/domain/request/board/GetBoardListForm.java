package com.middleware.mobile.domain.request.board;

import lombok.Getter;

@Getter
public class GetBoardListForm {

    private String keyword;
    private int page;
    private int rowCount;
}
