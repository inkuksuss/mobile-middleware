package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.NoticeDto;
import com.middleware.mobile.domain.dto.ParticipationDto;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface NoticeService {

    ResultResponse<List<NoticeDto>> getParticipationList(NoticeDto noticeDto) throws SQLException;

    ResultResponse<List<NoticeDto>> insertParticipation(NoticeDto noticeDto) throws SQLException;

    ResultResponse<List<NoticeDto>> updateParticipation(NoticeDto noticeDto) throws SQLException;

    ResultResponse<List<NoticeDto>> deleteParticipation(NoticeDto noticeDto) throws SQLException;
}
