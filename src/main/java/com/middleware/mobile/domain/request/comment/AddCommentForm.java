package com.middleware.mobile.domain.request.comment;

import lombok.Getter;

import java.sql.Timestamp;


@Getter
public class AddCommentForm {
    private Long boardId;
    private String commentBody;
    private Long parentId;
    private String commentStatus;
}
