package com.middleware.mobile.domain.request.comment;

import lombok.Getter;

import java.sql.Timestamp;


@Getter
public class AddCommentForm {
    private Long boardId;
    private Long parentId;
    private String commentBody;
    private String commentStatus;
}
