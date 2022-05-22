package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.ParticipationDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Mapper
public interface ParticipationRepository {

    List<ParticipationDto> getParticipationList(ParticipationDto participationDto) throws SQLException;

    int insertParticipation(ParticipationDto participationDto) throws SQLException;

    int updateParticipation(ParticipationDto participationDto) throws SQLException;

    int deleteParticipation(ParticipationDto participationDto) throws SQLException;
}
