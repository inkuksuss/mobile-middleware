package com.middleware.mobile.domain.dto;

import java.sql.Timestamp;

public class AddCategoryDto {

    private Long categoryId;
    private Long memberId;
    private String categoryName;
    private String categoryStatus;
    private Timestamp categoryCreated;
    private Timestamp categoryUpdated;
    private char stateDel;
}
