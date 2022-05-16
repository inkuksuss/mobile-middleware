package com.middleware.mobile.domain.request.comment;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class UpdateCommentForm {

    private Long commentId;
    private Long memberId;
    private Long parentId;
    private String commentBody;
    private String commentStatus;
    private Timestamp commentUpdated;
}
