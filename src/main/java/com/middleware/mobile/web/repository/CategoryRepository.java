package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Mapper
@Repository
public interface CategoryRepository {

    Optional<CategoryDto> findCategoryById() throws SQLException;

    List<CategoryDto> getCategoryList() throws SQLException;

    List<BoardDto> getCategoryAssetList() throws SQLException;

    void addCategory() throws SQLException;

    void updateCategory() throws SQLException;

    void deleteCategory() throws SQLException;
}
