package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.CategoryDto;
import com.middleware.mobile.web.repository.CategoryRepository;
import com.middleware.mobile.web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoryList(CategoryDto categoryDto) throws SQLException {

        return categoryRepository.getCategoryList(categoryDto);
    }

    @Override
    public void addCategory() throws SQLException {

    }

    @Override
    public void updateCategory() throws SQLException {

    }

    @Override
    public void deleteCategory() throws SQLException {

    }
}
