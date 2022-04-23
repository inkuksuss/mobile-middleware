package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {

    ResultResponse<List<CommentDto>> getCommentList(GetCommentDto getCommentDto) throws SQLException;

    ResultResponse<List<CommentDto>> addComment(CommentDto commentDto) throws SQLException;

    ResultResponse<List<CommentDto>> updateComment(CommentDto commentDto) throws SQLException;

    ResultResponse<List<CommentDto>> deleteComment(CommentDto commentDto) throws SQLException;
}
