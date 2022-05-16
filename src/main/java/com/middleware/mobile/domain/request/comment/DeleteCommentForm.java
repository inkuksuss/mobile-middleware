package com.middleware.mobile.domain.request.comment;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteCommentForm {
    private Long commentId;
    private Long memberId;
    private Long parentId;
    private Boolean childFlag;
}
