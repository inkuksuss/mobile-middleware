package com.middleware.mobile.domain.dto;

import com.middleware.mobile.domain.request.comment.AddCommentForm;
import com.middleware.mobile.domain.request.comment.UpdateCommentForm;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentDto {

    private Long commentId;
    private Long boardId;
    private Long memberId;
    private Long parentId;
    private String commentBody;
    private String commentStatus;
    private Timestamp commentCreated;
    private Timestamp commentUpdated;
    private char stateDel;
    private int childCount;

    private short memberGrade;
    private String memberName;
    private String memberEmail;
    private String memberStudentId;
    private String memberAlias;
    private String memberDepartment;
    private String memberPhone;
    private String memberStatus;
    private String memberBirthday;
    private String memberPassword;
    private Timestamp memberCreated;
    private Timestamp memberUpdated;
    private char memberAuthority;
    private char memberStateDel;

    private String boardStatus;
    private char boardStateDel;

    private CommentDto() {}

    public static CommentDto createGetCommentDto(Long memberId) {
        CommentDto commentDto = new CommentDto();
        commentDto.memberId = memberId;
        return commentDto;
    }

    public static CommentDto createAddCommentDto(AddCommentForm form, Long memberId) {
        CommentDto commentDto = new CommentDto();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        commentDto.boardId = form.getBoardId();
        commentDto.commentBody = form.getCommentBody();
        commentDto.commentStatus = form.getCommentStatus();
        commentDto.memberId = memberId;
        commentDto.commentCreated = currentTime;
        commentDto.commentUpdated = currentTime;
        commentDto.stateDel = 'N';

        if (form.getParentId() != null && form.getParentId() > 0) {
            commentDto.parentId = form.getParentId();
        }

        return commentDto;
    }

    public static CommentDto createUpdateCommentDto(UpdateCommentForm form) {
        CommentDto commentDto = new CommentDto();
        commentDto.commentId = form.getCommentId();
        commentDto.memberId = form.getMemberId();
        commentDto.commentBody = form.getCommentBody();
        commentDto.commentStatus = form.getCommentStatus();
        commentDto.commentUpdated = new Timestamp(System.currentTimeMillis());

        return commentDto;
    }

    public static CommentDto createDeleteCommentDto(Long commentId, Long memberId) {
        CommentDto commentDto = new CommentDto();
        commentDto.commentId = commentId;
        commentDto.memberId = memberId;

        return commentDto;
    }
}
