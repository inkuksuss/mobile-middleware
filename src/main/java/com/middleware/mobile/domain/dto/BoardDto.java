package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class BoardDto {

    private Long boardId;
    private Long categoryId;
    private Long memberId;
    private String memberAlias;
    private String categoryName;
    private String boardTitle;
    private String boardBody;
    private Timestamp boardUpdated;
    private String boardStatus;
    private int boardScore;
    private int boardView;
    private char memberAuthority;
    private char stateDel;

    private Long reqMemberId;
    private Boolean isOwnerFlag;

    public BoardDto() {}

    public static BoardDto from(CategoryAssetDto categoryAssetDto) {
        BoardDto boardDto = new BoardDto();
        boardDto.boardId = categoryAssetDto.getBoardId();
        boardDto.categoryId = categoryAssetDto.getCategoryId();
        boardDto.memberId = categoryAssetDto.getMemberId();
        boardDto.memberAlias = categoryAssetDto.getMemberAlias();
        boardDto.categoryName = categoryAssetDto.getCategoryName();
        boardDto.boardTitle = categoryAssetDto.getBoardTitle();
        boardDto.boardBody = categoryAssetDto.getBoardBody();
        boardDto.boardUpdated = categoryAssetDto.getBoardUpdated();
        boardDto.memberAuthority = categoryAssetDto.getMemberAuthority();
        boardDto.boardStatus = categoryAssetDto.getBoardStatus();
        boardDto.boardScore = categoryAssetDto.getBoardScore();
        boardDto.boardView = categoryAssetDto.getBoardView();
        boardDto.stateDel = categoryAssetDto.getBoardStateDel();

        return boardDto;
    }
}
