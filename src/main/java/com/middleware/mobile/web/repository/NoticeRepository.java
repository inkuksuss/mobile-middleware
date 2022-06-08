package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeRepository {

    List<NoticeDto> getNoticeList(NoticeDto noticeDto);

    int insertNotice(NoticeDto noticeDto);

    int updateNotice(NoticeDto noticeDto);

    int deleteNotice(NoticeDto noticeDto);
}
