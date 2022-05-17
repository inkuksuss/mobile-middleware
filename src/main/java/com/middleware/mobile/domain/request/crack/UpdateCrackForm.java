package com.middleware.mobile.domain.request.crack;

import lombok.Getter;

@Getter
public class UpdateCrackForm {
    private Long crackId;
    private String crackName;
    private String crackStatus;
}
