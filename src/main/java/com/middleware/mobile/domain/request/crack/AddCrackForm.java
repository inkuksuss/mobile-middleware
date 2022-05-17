package com.middleware.mobile.domain.request.crack;

import lombok.Getter;

@Getter
public class AddCrackForm {

    private Long channelId;
    private String crackName;
    private String crackStatus;
}
