package com.middleware.mobile.web.service;

import com.middleware.mobile.domain.dto.ParticipationDto;
import com.middleware.mobile.domain.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface ParticipationService {

    ResultResponse<List<ParticipationDto>> getParticipationList(ParticipationDto participationDto) throws SQLException;

    ResultResponse<List<ParticipationDto>> insertParticipation(ParticipationDto participationDto) throws SQLException;

    ResultResponse<List<ParticipationDto>> updateParticipation(ParticipationDto participationDto) throws SQLException;

    ResultResponse<List<ParticipationDto>> deleteParticipation(ParticipationDto participationDto) throws SQLException;
}
