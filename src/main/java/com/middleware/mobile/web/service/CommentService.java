package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {

    List<CommentDto> getCommentList(GetCommentDto getCommentDto) throws SQLException;

    List<CommentDto> addComment(CommentDto commentDto) throws SQLException;

    List<CommentDto> updateComment(CommentDto commentDto) throws SQLException;

    List<CommentDto> deleteComment(CommentDto commentDto) throws SQLException;
}
