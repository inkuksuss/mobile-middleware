package com.middleware.mobile.web.repository;


import com.middleware.mobile.domain.dto.FeedbackDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FeedbackRepository {

    List<FeedbackDto> getFeedbackList(FeedbackDto feedbackDto);
    int insertFeedback(FeedbackDto feedbackDto);
    int updatedFeedback(FeedbackDto feedbackDto);
    int deleteFeedback(FeedbackDto feedbackDto);
}
