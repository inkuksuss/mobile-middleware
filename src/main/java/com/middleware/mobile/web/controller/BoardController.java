package com.middleware.mobile.web.controller;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.common.Delete;
import com.middleware.mobile.domain.dto.AddBoardDto;
import com.middleware.mobile.domain.dto.DeleteBoardDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.dto.UpdateBoardDto;
import com.middleware.mobile.domain.request.board.AddBoardForm;
import com.middleware.mobile.domain.request.board.UpdateBoardForm;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/about/{categoryName}")
    public ResultResponse<Void> getBoardList(@PathVariable String categoryName) throws Exception {

        if (categoryName.equals("common")) {

        } else if (categoryName.equals("notice")) {

        } else if (categoryName.equals("share")) {

        } else {
            return new ResultResponse<>(HttpStatus.NOT_FOUND, ResultCode.PAGE_NOT_FOUND.getCode(), ResultCode.PAGE_NOT_FOUND.getMessage());
        }
    }

    @PostMapping("/add")
    public ResultResponse<Long> addBoard(@RequestBody AddBoardForm form, HttpSession httpSession) throws Exception {

        SessionDto sessionDto = (SessionDto) httpSession.getAttribute(Authority.MEMBER.name());

        AddBoardDto addBoardDto = createAddBoardDto(form);
        addBoardDto.setMemberId(sessionDto.getMemberId());
        boardService.addBoard(addBoardDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), addBoardDto.getBoardId());
    }

    private AddBoardDto createAddBoardDto(AddBoardForm form) {
        AddBoardDto addBoardDto = new AddBoardDto();
        addBoardDto.setBoardTitle(form.getBoardTitle());
        addBoardDto.setBoardBody(form.getBoardBody());
        addBoardDto.setBoardStatus(form.getBoardStatus());
        addBoardDto.setBoardCreated(new Timestamp(System.currentTimeMillis()));
        addBoardDto.setBoardUpdated(new Timestamp(System.currentTimeMillis()));
        addBoardDto.setBoardScore(0);
        addBoardDto.setBoardView(0);
        addBoardDto.setStateDel(Delete.EXIST.getValue());

        return addBoardDto;
    }

    @PostMapping("/update/{boardId}")
    public ResultResponse<Long> updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardForm form, HttpSession httpSession) throws Exception {

        SessionDto sessionDto = (SessionDto) httpSession.getAttribute(Authority.MEMBER.name());

        UpdateBoardDto updateBoardDto = createUpdateBoardDto(form);
        updateBoardDto.setBoardId(boardId);
        updateBoardDto.setMemberId(sessionDto.getMemberId());

        boardService.updateBoard(updateBoardDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), updateBoardDto.getBoardId());
    }

    private UpdateBoardDto createUpdateBoardDto(UpdateBoardForm form) {
        UpdateBoardDto updateBoardDto = new UpdateBoardDto();
        updateBoardDto.setCategoryId(form.getCategoryId());
        updateBoardDto.setBoardTitle(form.getBoardTitle());
        updateBoardDto.setBoardBody(form.getBoardBody());
        updateBoardDto.setBoardStatus(form.getBoardStatus());
        updateBoardDto.setBoardUpdated(new Timestamp(System.currentTimeMillis()));

        return updateBoardDto;
    }

    @PostMapping("/delete/{boardId}")
    public ResultResponse<Void> deleteBoard(@PathVariable Long boardId, HttpSession httpSession) throws Exception {

        SessionDto sessionDto = (SessionDto) httpSession.getAttribute(Authority.MEMBER.name());

        DeleteBoardDto deleteBoardDto = new DeleteBoardDto(boardId, sessionDto.getMemberId());
        boardService.deleteBoard(deleteBoardDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }
}