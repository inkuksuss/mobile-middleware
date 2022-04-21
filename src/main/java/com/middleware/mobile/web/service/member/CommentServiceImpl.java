package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;
import com.middleware.mobile.web.exception.custom.BoardNotFoundException;
import com.middleware.mobile.web.repository.BoardRepository;
import com.middleware.mobile.web.repository.CommentRepository;
import com.middleware.mobile.web.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<CommentDto> getCommentList(GetCommentDto getCommentDto) throws SQLException {
        BoardDto boardDto = boardRepository.findBoardById(getCommentDto.getBoardId()).orElseThrow(() -> new BoardNotFoundException("존재하지 않는 게시판입니다."));

        if (getCommentDto.getMemberId() != null && getCommentDto.getMemberId() > 0) {
            if (boardDto.getMemberId().equals(getCommentDto.getMemberId())) {
                return commentRepository.getCommentListByOwner(getCommentDto);
            } else {
                throw new IllegalArgumentException("적절하지 않은 요청입니다.");
            }
        }
        return commentRepository.getCommentList(getCommentDto);
    };

    @Override
    public List<CommentDto> addComment(CommentDto commentDto) throws SQLException {
        commentRepository.addComment(commentDto);
        GetCommentDto getCommentDto = createGetCommentDto(commentDto);

        return this.getCommentList(new GetCommentDto(commentDto.getBoardId(), commentDto.getMemberId()));
    }

    private GetCommentDto createGetCommentDto(CommentDto commentDto) {
        GetCommentDto getCommentDto = new GetCommentDto();
        getCommentDto.setMemberId(commentDto.getMemberId());
        getCommentDto.setBoardId(commentDto.getBoardId());
        return getCommentDto;
    }

    @Override
    public List<CommentDto> updateComment(CommentDto commentDto) throws SQLException {
        commentRepository.updateComment(commentDto);

        return this.getCommentList(new GetCommentDto(commentDto.getBoardId(), commentDto.getMemberId()));
    };

    @Override
    public List<CommentDto> deleteComment(CommentDto commentDto) throws SQLException {
        commentRepository.deleteComment(commentDto);

        return this.getCommentList(new GetCommentDto(commentDto.getBoardId(), commentDto.getMemberId()));
    };
}
