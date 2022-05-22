package com.middleware.mobile.domain.request.channel;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class GetChannelForm {
    private Long channelId;
    private Long memberId;
    private String channelName;
    private String channelState;
}
