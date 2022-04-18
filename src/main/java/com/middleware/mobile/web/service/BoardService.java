package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.AddBoardDto;
import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.DeleteBoardDto;
import com.middleware.mobile.domain.dto.UpdateBoardDto;
import com.middleware.mobile.web.repository.BoardRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    List<BoardDto> getBoardList() throws SQLException;

    Optional<BoardDto> getBoard() throws SQLException;

    void addBoard(AddBoardDto addBoardDto) throws SQLException;

    void updateBoard(UpdateBoardDto updateBoardDto) throws SQLException;

    void deleteBoard(DeleteBoardDto deleteBoardDto) throws SQLException;
}
