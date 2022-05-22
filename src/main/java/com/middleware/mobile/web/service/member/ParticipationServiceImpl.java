package com.middleware.mobile.web.service.member;

import com.middleware.mobile.domain.dto.ChannelDto;
import com.middleware.mobile.domain.dto.ParticipationDto;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.repository.ChannelRepository;
import com.middleware.mobile.web.repository.ParticipationRepository;
import com.middleware.mobile.web.service.ParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRepository participationRepository;
    private final ChannelRepository channelRepository;

    @Override
    public ResultResponse<List<ParticipationDto>> getParticipationList(ParticipationDto participationDto) throws SQLException {
        List<ParticipationDto> participationList = participationRepository.getParticipationList(participationDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), participationList);
    }

    @Override
    public ResultResponse<List<ParticipationDto>> insertParticipation(ParticipationDto participationDto) throws SQLException {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setChannelId(participationDto.getChannelId());
        channelDto.setMemberId(participationDto.getLoginMemberId());
        List<ChannelDto> channelList = channelRepository.getChannelList(channelDto);

        if (channelList.size() > 0) {
            int result = participationRepository.insertParticipation(participationDto);

            if (result == 1) {
                ParticipationDto dto = new ParticipationDto();
                dto.setChannelId(participationDto.getChannelId());
                List<ParticipationDto> participationList = participationRepository.getParticipationList(dto);

                return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), participationList);
            } else {
                return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
            }
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<List<ParticipationDto>> updateParticipation(ParticipationDto participationDto) throws SQLException {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setChannelId(participationDto.getChannelId());
        channelDto.setMemberId(participationDto.getLoginMemberId());
        List<ChannelDto> channelList = channelRepository.getChannelList(channelDto);

        if (channelList.size() > 0) {
            int result = participationRepository.updateParticipation(participationDto);

            if (result == 1) {
                ParticipationDto dto = new ParticipationDto();
                dto.setChannelId(participationDto.getChannelId());

                List<ParticipationDto> participationList = participationRepository.getParticipationList(dto);

                return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), participationList);
            } else {
                return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
            }

        } else {
                return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }

    @Override
    public ResultResponse<List<ParticipationDto>> deleteParticipation(ParticipationDto participationDto) throws SQLException {
        ChannelDto channelDto = new ChannelDto();
        channelDto.setChannelId(participationDto.getChannelId());
        channelDto.setMemberId(participationDto.getLoginMemberId());
        List<ChannelDto> channelList = channelRepository.getChannelList(channelDto);

        if (channelList.size() > 0) {
            int result = participationRepository.deleteParticipation(participationDto);

            if (result == 1) {
                ParticipationDto dto = new ParticipationDto();
                dto.setChannelId(participationDto.getChannelId());

                List<ParticipationDto> participationList = participationRepository.getParticipationList(dto);

                return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), participationList);
            } else {
                return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
            }
        } else {
            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
        }
    }
}
