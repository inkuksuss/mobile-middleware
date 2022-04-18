package com.middleware.mobile.domain.dto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteBoardDto {

    private final long boardId;
    private final long memberId;
}
