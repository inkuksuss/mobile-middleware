package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.AddBoardDto;
import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.DeleteBoardDto;
import com.middleware.mobile.domain.dto.UpdateBoardDto;
import com.middleware.mobile.web.repository.BoardRepository;
import com.middleware.mobile.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public List<BoardDto> getBoardList() throws SQLException {

    }

    @Override
    public Optional<BoardDto> getBoard() throws SQLException {

    }

    @Override
    public void addBoard(AddBoardDto addBoardDto) throws SQLException {
        boardRepository.addBoard(addBoardDto);
    }

    @Override
    public void updateBoard(UpdateBoardDto updateBoardDto) throws SQLException {
        boardRepository.updateBoard(updateBoardDto);
    }

    @Override
    public void deleteBoard(DeleteBoardDto deleteBoardDto) throws SQLException {
        boardRepository.deleteBoard(deleteBoardDto);
    }
}
