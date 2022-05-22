package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.ChannelDto;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.repository.ChannelRepository;
import com.middleware.mobile.web.service.ChannelService;
import com.middleware.mobile.web.utils.MemberAuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    @Override
    public ResultResponse<List<ChannelDto>> getChannelList(ChannelDto channelDto) throws SQLException {
        List<ChannelDto> channelList = channelRepository.getChannelList(channelDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), channelList);
    }

    @Override
    public ResultResponse<List<ChannelDto>> insertChannel(ChannelDto channelDto) throws SQLException {

        int result = channelRepository.insertChannel(channelDto);

        if (result == 1) {
            ChannelDto dto = new ChannelDto();
            dto.setChannelId(channelDto.getChannelId());
            List<ChannelDto> channelDtoList = channelRepository.getChannelList(dto);

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), channelDtoList);
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<List<ChannelDto>> updateChannel(ChannelDto channelDto) throws SQLException {
        int result = channelRepository.updateChannel(channelDto);

        if (result == 1) {
            ChannelDto dto = new ChannelDto();
            dto.setChannelId(channelDto.getChannelId());
            List<ChannelDto> channelDtoList = channelRepository.getChannelList(dto);

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), channelDtoList);
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<List<ChannelDto>> deleteChannel(ChannelDto channelDto) throws SQLException {
        int result = channelRepository.deleteChannel(channelDto);

        if (result == 1) {
            ChannelDto dto = new ChannelDto();
            dto.setChannelId(channelDto.getChannelId());
            List<ChannelDto> channelDtoList = channelRepository.getChannelList(dto);

            return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), channelDtoList);
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }
}
