package com.middleware.mobile.domain.dto;

import com.middleware.mobile.domain.common.Status;
import com.middleware.mobile.domain.request.board.GetBoardListForm;
import com.middleware.mobile.web.utils.MobileValidationUtils;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@Getter
public class CategoryAssetDto {

    private Long boardId;
    private String categoryName;
    private String boardTitle;
    private String boardBody;
    private Timestamp boardUpdated;
    private String boardStatus;
    private int boardScore;
    private int boardView;
    private char boardStateDel;

    private Long memberId;
    private short memberGrade;
    private String memberAlias;
    private String memberName;
    private String memberEmail;
    private String memberStudentId;
    private String memberDepartment;
    private String memberPhone;
    private String memberStatus;
    private String memberBirthday;
    private String memberPassword;
    private Timestamp memberCreated;
    private Timestamp memberUpdated;
    private char memberAuthority;
    private char memberStateDel;

    private Long categoryId;
    private Long categoryMemberId;
    private String categoryStatus;
    private Timestamp categoryCreated;
    private Timestamp categoryUpdated;

    private String keyword;
    private int page;
    private int rowCount;
    private int totalCount;

    private Long reqMemberId;

    private CategoryAssetDto() {}

    public static CategoryAssetDto of(GetBoardListForm getBoardListForm, String categoryName, @Nullable Long reqMemberId) {
        CategoryAssetDto categoryAssetDto = new CategoryAssetDto();
        categoryAssetDto.keyword = categoryAssetDto.getKeyword();
        categoryAssetDto.page = categoryAssetDto.getPage() > 0 ? categoryAssetDto.getPage() : 1;
        categoryAssetDto.rowCount = categoryAssetDto.getRowCount() > 0 ? categoryAssetDto.getRowCount() : 10;
        categoryAssetDto.categoryName = categoryName;
        categoryAssetDto.categoryStatus = Status.PUBLIC.getValue();
        categoryAssetDto.boardStatus = Status.PUBLIC.getValue();
        categoryAssetDto.memberStatus = Status.PUBLIC.getValue();
        if (isExist(reqMemberId)) {
            categoryAssetDto.reqMemberId = reqMemberId;
        }

        return categoryAssetDto;
    }
}
