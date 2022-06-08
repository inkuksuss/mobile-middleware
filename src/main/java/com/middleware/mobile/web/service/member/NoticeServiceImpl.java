//package com.middleware.mobile.web.service.member;
//
//
//import com.middleware.mobile.domain.dto.ChannelDto;
//import com.middleware.mobile.domain.dto.CrackDto;
//import com.middleware.mobile.domain.dto.NoticeDto;
//import com.middleware.mobile.domain.dto.ParticipationDto;
//import com.middleware.mobile.domain.response.ResultCode;
//import com.middleware.mobile.domain.response.ResultResponse;
//import com.middleware.mobile.web.repository.CrackRepository;
//import com.middleware.mobile.web.repository.NoticeRepository;
//import com.middleware.mobile.web.service.NoticeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NoticeServiceImpl implements NoticeService {
//
//    private final NoticeRepository noticeRepository;
//    private final CrackRepository crackRepository;
//
//    @Override
//    public ResultResponse<List<NoticeDto>> getParticipationList(NoticeDto noticeDto) throws SQLException {
//        List<NoticeDto> noticeList = noticeRepository.getNoticeList(noticeDto);
//
//        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), noticeList);
//    }
//
//    @Override
//    public ResultResponse<List<NoticeDto>> insertParticipation(NoticeDto noticeDto) throws SQLException {
//        CrackDto crackDto = new CrackDto();
//        crackDto.setChannelId(noticeDto.getChannelId());
//        crackDto.setMemberId(noticeDto.getLoginMemberId());
//        List<ChannelDto> channelList = channelRepository.getChannelList(channelDto);
//
//        if (channelList.size() > 0) {
//            int result = participationRepository.insertParticipation(participationDto);
//
//            if (result == 1) {
//                ParticipationDto dto = new ParticipationDto();
//                dto.setChannelId(participationDto.getChannelId());
//                List<ParticipationDto> participationList = participationRepository.getParticipationList(dto);
//
//                return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), participationList);
//            } else {
//                return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
//            }
//        } else {
//            return new ResultResponse<>(HttpStatus.BAD_REQUEST, ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
//        }
//    }
//
//    @Override
//    public ResultResponse<List<NoticeDto>> updateParticipation(NoticeDto noticeDto) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public ResultResponse<List<NoticeDto>> deleteParticipation(NoticeDto noticeDto) throws SQLException {
//        return null;
//    }
//}
