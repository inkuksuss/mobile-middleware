package com.middleware.mobile.web.service.admin;

import com.middleware.mobile.domain.dto.BoardDto;
import com.middleware.mobile.domain.dto.CategoryDto;
import com.middleware.mobile.web.service.CategoryService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class AdminCategoryServiceImpl implements CategoryService {

    @Override
    public void addCategory() throws SQLException{}

    @Override
    public void updateCategory() throws SQLException{}

    @Override
    public void deleteCategory() throws SQLException {}

    @Override
    public List<CategoryDto> getCategoryList(CategoryDto categoryDto) throws SQLException {
        return null;
    }
}
