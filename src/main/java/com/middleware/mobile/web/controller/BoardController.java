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
import com.middleware.mobile.web.service.MemberService;
import com.middleware.mobile.web.utils.MobileValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CategoryService categoryService;
    private final MemberService memberService;

    @PostMapping("/about/{categoryName}")
    public ResultResponse<List<BoardDto>> getBoardList(@PathVariable String categoryName, @RequestBody GetBoardListForm form, HttpServletRequest httpServletRequest) throws Exception {



        Long loginUserId = memberService.getLoginUserId(httpServletRequest);

        CategoryAssetDto categoryAssetDto = CategoryAssetDto.of(form, categoryName, isExist(loginUserId) ? loginUserId : null);
        return boardService.getBoardList(categoryAssetDto);
    }

    @GetMapping("/about/{categoryName}/{boardId}")
    public ResultResponse<BoardDto> getBoard(@PathVariable String categoryName, @PathVariable Long boardId, HttpServletRequest httpServletRequest) throws Exception {
        Long loginUserId = memberService.getLoginUserId(httpServletRequest);
        BoardDto boardDto = new BoardDto();
        boardDto.setReqMemberId(loginUserId);
        boardDto.setBoardId(boardId);
        boardDto.setCategoryName(categoryName);


        return boardService.getBoard(boardDto);
    }

    @PostMapping("/add")
    public ResultResponse<Long> addBoard(@RequestBody AddBoardForm form, HttpServletRequest httpServletRequest) throws Exception {

        Long loginMemberId = memberService.getLoginUserId(httpServletRequest);

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
    public ResultResponse<Long> updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardForm form, HttpServletRequest httpServletRequest) throws Exception {

        Long loginUserId = memberService.getLoginUserId(httpServletRequest);

        UpdateBoardDto updateBoardDto = createUpdateBoardDto(form);
        updateBoardDto.setBoardId(boardId);
        updateBoardDto.setMemberId(loginUserId);

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
