package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.ChannelDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChannelRepository {

    List<ChannelDto> getChannelList(ChannelDto channelDto);
    int insertChannel(ChannelDto channelDto);
    int updateChannel(ChannelDto channelDto);
    int deleteChannel(ChannelDto channelDto);
}
