package com.middleware.mobile.web.repository;

import com.middleware.mobile.domain.dto.CrackAssetDto;
import com.middleware.mobile.domain.dto.CrackDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CrackRepository {

    List<CrackAssetDto> getCrackAssetList(CrackDto crackDto);

    List<CrackDto> getCrackList(CrackDto crackDto);

    int insertCrack(CrackDto crackDto);

    int updateCrack(CrackDto crackDto);

    int deleteCrack(CrackDto crackDto);
}
