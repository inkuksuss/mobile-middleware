package com.middleware.mobile.domain.request.channel;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateChannelForm {
    private String channelName;
    private String channelState;
}
