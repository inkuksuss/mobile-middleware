package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {

    ResultResponse<List<BoardDto>> getBoardList(CategoryAssetDto categoryAssetDto) throws SQLException;

    ResultResponse<BoardDto> getBoard(BoardDto boardDto) throws SQLException;

    ResultResponse<Long> addBoard(AddBoardDto addBoardDto) throws SQLException;

    ResultResponse<Long> updateBoard(UpdateBoardDto updateBoardDto) throws SQLException;

    ResultResponse<Void> deleteBoard(DeleteBoardDto deleteBoardDto) throws SQLException;
}
