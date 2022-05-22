package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.ChannelDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Mapper
public interface ChannelRepository {

    List<ChannelDto> getChannelList(ChannelDto channelDto) throws SQLException;

    int insertChannel(ChannelDto channelDto) throws SQLException;

    int updateChannel(ChannelDto channelDto) throws SQLException;

    int deleteChannel(ChannelDto channelDto) throws SQLException;
}
