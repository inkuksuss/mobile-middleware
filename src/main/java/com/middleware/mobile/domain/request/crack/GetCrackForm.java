package com.middleware.mobile.domain.request.crack;


import lombok.Getter;

@Getter
public class GetCrackForm {
    private Long crackId;
    private Long memberId;
    private Long channelId;
    private String crackName;
    private String crackStatus;
}
