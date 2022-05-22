package com.middleware.mobile.domain.request.particaption;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddParticipationForm {

    private Long channelId;
    private Long memberId;
    private String participationAuthority;
}
