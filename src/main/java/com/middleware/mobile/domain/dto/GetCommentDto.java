package com.middleware.mobile.domain.dto;


import com.middleware.mobile.web.utils.MobileValidationUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

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

    public GetCommentDto(Long boardId) {
        this.boardId = boardId;
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

    public static GetCommentDto parentOf(Long boardId, Long parentId, Long boardMemberId) {
        GetCommentDto getCommentDto = new GetCommentDto();
        getCommentDto.boardId = boardId;
        getCommentDto.parentId = parentId;
        if (isExist(boardMemberId)) {
            getCommentDto.boardMemberId = boardMemberId;
        }
        return getCommentDto;
    }
}
