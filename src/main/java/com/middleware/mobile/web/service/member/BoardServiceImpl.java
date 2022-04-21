package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.web.repository.BoardRepository;
import com.middleware.mobile.web.repository.CategoryRepository;
import com.middleware.mobile.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<BoardDto> getBoardList(CategoryAssetDto categoryAssetDto) throws SQLException {
        List<CategoryAssetDto> categoryAssetList = categoryRepository.getCategoryAssetList(categoryAssetDto);

        return categoryAssetList.stream().map(BoardDto::from).collect(Collectors.toList());
    }

    @Override
    public BoardDto getBoard(CategoryAssetDto categoryAssetDto) throws SQLException {
        List<CategoryAssetDto> categoryAssetList = categoryRepository.getCategoryAssetList(categoryAssetDto);

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
