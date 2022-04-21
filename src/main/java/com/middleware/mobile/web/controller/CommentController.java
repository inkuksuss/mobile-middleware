package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.request.comment.AddCommentForm;
import com.middleware.mobile.domain.request.comment.UpdateCommentForm;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.CommentService;
import com.middleware.mobile.web.utils.MemberAuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get/{boardId}")
    public ResultResponse<List<CommentDto>> getCommentList(@PathVariable Long boardId, HttpSession httpSession) throws Exception {

        GetCommentDto getCommentDto = new GetCommentDto();
        getCommentDto.setBoardId(boardId);

        if (MemberAuthenticationUtils.isLogin(httpSession)) {
            SessionDto loginMember = MemberAuthenticationUtils.getLoginMember(httpSession);
            getCommentDto.setMemberId(loginMember.getMemberId());
        }

        List<CommentDto> commentDtoList = commentService.getCommentList(getCommentDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentDtoList);
    };

    @PostMapping("/add/{boardId}")
    public ResultResponse<List<CommentDto>> addComment(@RequestBody AddCommentForm form, @PathVariable Long boardId, HttpSession httpSession) throws Exception {

        SessionDto loginMember = MemberAuthenticationUtils.getLoginMember(httpSession);

        CommentDto commentDto = CommentDto.createAddCommentDto(form, loginMember.getMemberId());
        List<CommentDto> commentDtoList = commentService.addComment(commentDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentDtoList);
    };

    @PostMapping("/update/{commentId}")
    public ResultResponse<List<CommentDto>> updateComment(@RequestBody UpdateCommentForm form, @PathVariable Long commentId, HttpSession httpSession) throws Exception {
        SessionDto loginMember = MemberAuthenticationUtils.getLoginMember(httpSession);

        form.setCommentId(commentId);
        form.setMemberId(loginMember.getMemberId());
        CommentDto commentDto = CommentDto.createUpdateCommentDto(form);

        List<CommentDto> commentDtoList = commentService.updateComment(commentDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentDtoList);
    };

    @PostMapping("/delete/{commentId}")
    public ResultResponse<List<CommentDto>> deleteComment(@PathVariable Long commentId, HttpSession httpSession) throws Exception {
        SessionDto loginMember = MemberAuthenticationUtils.getLoginMember(httpSession);
        CommentDto commentDto = CommentDto.createDeleteCommentDto(commentId, loginMember.getMemberId());

        List<CommentDto> commentDtoList = commentService.deleteComment(commentDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentDtoList);
    };
}