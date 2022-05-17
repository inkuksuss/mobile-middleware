package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.common.Status;
import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.exception.custom.BoardNotFoundException;
import com.middleware.mobile.web.repository.BoardRepository;
import com.middleware.mobile.web.repository.CategoryRepository;
import com.middleware.mobile.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ResultResponse<List<BoardDto>> getBoardList(CategoryAssetDto categoryAssetDto) throws SQLException {

        CategoryDto categoryDto = CategoryDto.addCategoryNameFrom(categoryAssetDto);
        List<CategoryDto> categoryList = categoryRepository.getCategoryList(categoryDto);

        if (categoryList.size() > 0) {
            List<CategoryAssetDto> categoryAssetList = categoryRepository.getCategoryAssetList(categoryAssetDto);
            int totalCount = categoryAssetList.get(0).getTotalCount();

            List<BoardDto> boardDtoList = categoryAssetList.stream().map(BoardDto::from).collect(Collectors.toList());

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), totalCount, boardDtoList);
        } else {
            return new ResultResponse<>(HttpStatus.NOT_FOUND, ResultCode.PAGE_NOT_FOUND.getCode(), ResultCode.PAGE_NOT_FOUND.getMessage());
        }
    }

    @Override
    public ResultResponse<BoardDto> getBoard(BoardDto boardDto) throws SQLException {
        BoardDto board = boardRepository.findBoardById(boardDto.getBoardId())
                .orElseThrow(() -> new BoardNotFoundException("존재하지 않는 게시판입니다."));

        return getBoardDtoResultResponse(board);
    }

    private ResultResponse<BoardDto> getBoardDtoResultResponse(BoardDto board) {
        if (isExist(board.getReqMemberId())) {
            if (board.getMemberId().longValue() == board.getReqMemberId().longValue()) {
                return getOwnerResponse(board);
            } else {
                return getCommonResponse(board);
            }
        } else {
            return getCommonResponse(board);
        }
    }

    private ResultResponse<BoardDto> getOwnerResponse(BoardDto board) {
        board.setIsOwnerFlag(true);
        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), board);
    }

    private ResultResponse<BoardDto> getCommonResponse(BoardDto board) {
        if (board.getBoardStatus().equals(Status.PUBLIC.getValue())) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), board);
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.DENIED.getCode(), ResultCode.DENIED.getMessage());
        }
    }

    @Override
    public ResultResponse<Long> addBoard(AddBoardDto addBoardDto) throws SQLException {
        int result = boardRepository.addBoard(addBoardDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), addBoardDto.getBoardId());
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<Long> updateBoard(UpdateBoardDto updateBoardDto) throws SQLException {
        int result = boardRepository.updateBoard(updateBoardDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), updateBoardDto.getBoardId());
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<Void> deleteBoard(DeleteBoardDto deleteBoardDto) throws SQLException {
        int result = boardRepository.deleteBoard(deleteBoardDto);
        if (result == 1) {
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }
}
