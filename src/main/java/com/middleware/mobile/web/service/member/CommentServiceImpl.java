package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;
import com.middleware.mobile.domain.dto.SessionDto;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.exception.custom.BoardNotFoundException;
import com.middleware.mobile.web.repository.BoardRepository;
import com.middleware.mobile.web.repository.CommentRepository;
import com.middleware.mobile.web.service.CommentService;
import com.middleware.mobile.web.utils.MemberAuthenticationUtils;
import com.middleware.mobile.web.utils.MobileValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public ResultResponse<List<CommentDto>> getCommentList(GetCommentDto getCommentDto) throws SQLException {
        BoardDto boardDto = boardRepository.findBoardById(getCommentDto.getBoardId()).orElseThrow(() -> new BoardNotFoundException("존재하지 않는 게시판입니다."));

        if (isExist(getCommentDto.getBoardMemberId())) {
            if (boardDto.getMemberId().equals(getCommentDto.getBoardMemberId())) {
                List<CommentDto> commentListByOwner = commentRepository.getCommentListByOwner(getCommentDto);
                return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentListByOwner);
            } else {
                throw new IllegalArgumentException("적절하지 않은 요청입니다.");
            }
        } else {
            List<CommentDto> commentList = commentRepository.getCommentList(getCommentDto);
            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), commentList);
        }
    };

    @Override
    public ResultResponse<List<CommentDto>> addComment(CommentDto commentDto) throws SQLException {
        commentRepository.addComment(commentDto);
        GetCommentDto getCommentDto = createGetCommentDto(commentDto);

        return getCommentList(new GetCommentDto(commentDto.getBoardId()));
    }

    private GetCommentDto createGetCommentDto(CommentDto commentDto) {
        GetCommentDto getCommentDto = new GetCommentDto();
        getCommentDto.setMemberId(commentDto.getMemberId());
        getCommentDto.setBoardId(commentDto.getBoardId());
        return getCommentDto;
    }

    @Override
    public ResultResponse<List<CommentDto>> updateComment(CommentDto commentDto) throws SQLException {
        commentRepository.updateComment(commentDto);

        return getCommentList(new GetCommentDto(commentDto.getBoardId()));
    };

    @Override
    public ResultResponse<List<CommentDto>> deleteComment(CommentDto commentDto) throws SQLException {
        commentRepository.deleteComment(commentDto);

        return getCommentList(new GetCommentDto(commentDto.getBoardId()));
    };
}
