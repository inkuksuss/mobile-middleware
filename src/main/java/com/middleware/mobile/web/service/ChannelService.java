package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.ChannelDto;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface ChannelService {

    ResultResponse<List<ChannelDto>> getChannelList(ChannelDto channelDto) throws SQLException;

    ResultResponse<List<ChannelDto>> insertChannel(ChannelDto channelDto) throws SQLException;

    ResultResponse<List<ChannelDto>> updateChannel(ChannelDto channelDto) throws SQLException;

    ResultResponse<List<ChannelDto>> deleteChannel(ChannelDto channelDto) throws SQLException;
}
