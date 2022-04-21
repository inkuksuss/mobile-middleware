package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.dto.CommentDto;
import com.middleware.mobile.domain.dto.GetCommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Mapper
public interface CommentRepository {

    List<CommentDto> getCommentList(GetCommentDto getCommentDto) throws SQLException;

    List<CommentDto> getCommentListByOwner(GetCommentDto getCommentDto) throws SQLException;

    void addComment(CommentDto commentDto) throws SQLException;

    void updateComment(CommentDto commentDto) throws SQLException;

    void deleteComment(CommentDto commentDto) throws SQLException;
}
