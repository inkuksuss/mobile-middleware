package com.middleware.mobile.web.controller;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.common.Delete;
import com.middleware.mobile.domain.dto.*;
import com.middleware.mobile.domain.request.board.AddBoardForm;
import com.middleware.mobile.domain.request.board.GetBoardListForm;
import com.middleware.mobile.domain.request.board.UpdateBoardForm;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.BoardService;
import com.middleware.mobile.web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

import static com.middleware.mobile.web.utils.MemberAuthenticationUtils.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CategoryService categoryService;

    @GetMapping("/about/{categoryName}")
    public ResultResponse<List<BoardDto>> getBoardList(@PathVariable String categoryName, @RequestBody GetBoardListForm form, HttpSession httpSession) throws Exception {

        CategoryAssetDto categoryAssetDto;

        if (isLogin(httpSession)) {
            Long loginMemberId = getLoginMemberId(httpSession);
            categoryAssetDto = CategoryAssetDto.of(form, categoryName, loginMemberId);
        } else {
            categoryAssetDto = CategoryAssetDto.of(form, categoryName, null);
        }

        return boardService.getBoardList(categoryAssetDto);
    }

    @GetMapping("/about/{categoryName}/{boardId}")
    public ResultResponse<BoardDto> getBoard(@PathVariable String categoryName, @PathVariable Long boardId, HttpSession httpSession) throws Exception {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(boardId);
        boardDto.setCategoryName(categoryName);

        if (isLogin(httpSession)) {
            Long loginMemberId = getLoginMemberId(httpSession);
            boardDto.setReqMemberId(loginMemberId);
        }

        return boardService.getBoard(boardDto);
    }

    @PostMapping("/add")
    public ResultResponse<Long> addBoard(@RequestBody AddBoardForm form, HttpSession httpSession) throws Exception {

        Long loginMemberId = getLoginMemberId(httpSession);

        AddBoardDto addBoardDto = createAddBoardDto(form);
        addBoardDto.setMemberId(loginMemberId);

        return boardService.addBoard(addBoardDto);
    }

    private AddBoardDto createAddBoardDto(AddBoardForm form) {
        AddBoardDto addBoardDto = new AddBoardDto();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        addBoardDto.setBoardTitle(form.getBoardTitle());
        addBoardDto.setBoardBody(form.getBoardBody());
        addBoardDto.setBoardStatus(form.getBoardStatus());
        addBoardDto.setCategoryId(form.getCategoryId());
        addBoardDto.setBoardCreated(currentTime);
        addBoardDto.setBoardUpdated(currentTime);
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

        return boardService.updateBoard(updateBoardDto);
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

        return boardService.deleteBoard(deleteBoardDto);
    }
}
