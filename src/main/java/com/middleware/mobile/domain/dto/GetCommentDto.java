package com.middleware.mobile.domain.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class GetCommentDto {

    private Long memberId;
    private Long boardId;
    private Long commentId;
    private Long parentId;
    private String commentBody;
    private String commentStatus;
    private String boardStatus;
    private String memberName;
    private String memberAlias;
    private String memberDepartment;
    private Timestamp commentCreated;
    private Timestamp commentUpdated;
    private char commentStateDel;
    private char memberAuthority;
    private short memberGrade;

    private Long boardMemberId;

    public GetCommentDto() {}

    public GetCommentDto(Long memberId) {
        this.memberId = memberId;
    }

    public GetCommentDto(Long boardId, Long memberId) {
        this.boardId = boardId;
        this.memberId = memberId;
    }

    public static GetCommentDto createGetCommentDtoOfOwner(Long boardId, Long boardMemberId) {
        GetCommentDto getCommentDto = new GetCommentDto();
        getCommentDto.boardId = boardId;
        getCommentDto.boardMemberId = boardMemberId;
        return getCommentDto;
    }
}
