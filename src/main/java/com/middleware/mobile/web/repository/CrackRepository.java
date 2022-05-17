package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.CrackAssetDto;
import com.middleware.mobile.domain.dto.CrackDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@Mapper
public interface CrackRepository {

    List<CrackDto> getCrackList(CrackDto crackDto) throws SQLException;

    int insertCrack(CrackDto crackDto) throws SQLException;

    int updateCrack(CrackDto crackDto) throws SQLException;

    int deleteCrack(CrackDto crackDto) throws SQLException;
}
