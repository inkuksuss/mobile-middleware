package com.middleware.mobile.domain.dto;

import com.middleware.mobile.domain.common.Status;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class CategoryDto {

    private Long categoryId;
    private Long memberId;
    private String categoryName;
    private String categoryStatus;
    private Timestamp categoryCreated;
    private Timestamp categoryUpdated;

    private String memberAlias;
    private char memberAuthority;

    private Long reqMemberId;
    private String type;

    public CategoryDto() {};

    public static CategoryDto addCategoryNameFrom(CategoryAssetDto categoryAssetDto) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.categoryName = categoryAssetDto.getCategoryName();
        categoryDto.type = Status.ACTIVE.getValue();
        return categoryDto;
    }
}
