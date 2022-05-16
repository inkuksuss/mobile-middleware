package com.middleware.mobile.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ChannelDto {

    private Long channelId;
    private Long memberId;
    private String channelName;
    private String channelState;
    private Timestamp channelCreated;
    private Timestamp channelUpdated;
    private char stateDel;
}
