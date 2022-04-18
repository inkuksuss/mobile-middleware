package com.middleware.mobile.domain.dto;

import java.sql.Timestamp;

public class CategoryDto {

    private Long categoryId;
    private Long memberId;
    private String categoryName;
    private String categoryStatus;
    private Timestamp categoryCreated;
    private Timestamp categoryUpdated;
    private char stateDel;
}
