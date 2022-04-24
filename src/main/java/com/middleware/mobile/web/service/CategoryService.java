package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.CategoryDto;
import com.middleware.mobile.web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void addCategory() throws SQLException;

    void updateCategory() throws SQLException;

    void deleteCategory() throws SQLException;
}
