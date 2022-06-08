package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.AddBoardDto;
import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.DeleteBoardDto;
import com.middleware.mobile.domain.dto.UpdateBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface BoardRepository {

    List<BoardDto> getBoardList() throws SQLException;

    Optional<BoardDto> findBoardById(long boardId) throws SQLException;

    int addBoard(AddBoardDto addBoardDto) throws SQLException;

    int updateBoard(UpdateBoardDto updateBoardDto) throws SQLException;

    int deleteBoard(DeleteBoardDto deleteBoardDto) throws SQLException;
}

