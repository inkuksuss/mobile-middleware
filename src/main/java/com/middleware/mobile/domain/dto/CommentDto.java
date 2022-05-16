package com.middleware.mobile.domain.dto;

import com.middleware.mobile.domain.request.comment.AddCommentForm;
import com.middleware.mobile.domain.request.comment.DeleteCommentForm;
import com.middleware.mobile.domain.request.comment.UpdateCommentForm;
import com.middleware.mobile.web.utils.MobileValidationUtils;
import lombok.Getter;

import java.sql.Timestamp;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

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

    private Long reqMemberId;

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
        commentDto.childCount = 0;
        commentDto.stateDel = 'N';
        if (isExist(form.getParentId())) {
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
        if (isExist(form.getParentId())) {
            commentDto.parentId = form.getParentId();
        }

        return commentDto;
    }

    public static CommentDto createDeleteCommentDto(DeleteCommentForm form) {
        CommentDto commentDto = new CommentDto();
        commentDto.commentId = form.getCommentId();
        commentDto.reqMemberId = form.getMemberId();
        if (isExist(form.getParentId())) {
            commentDto.parentId = form.getParentId();
        }

        return commentDto;
    }
}
