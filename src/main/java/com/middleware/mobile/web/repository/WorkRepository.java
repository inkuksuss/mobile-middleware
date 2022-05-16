package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.dto.WorkDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WorkRepository {

    List<WorkDto> getWorkList(WorkDto workDto);
    int insertWork(WorkDto workDto);
    int updateWork(WorkDto workDto);
    int deleteWork(WorkDto workDto);
}
