package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.dto.NoticeDto;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private NoticeService noticeService;

//    @PostMapping("/getNoticeList")
//    public ResultResponse<List<NoticeDto>> getNoticeList() {
//        return noticeService.getParticipationList();
//    }
//
//    @PostMapping("/insertNotice")
//    public ResultResponse<List<NoticeDto>> insertNotice() {
//        return noticeService.insertParticipation();
//    }
//
//    @PostMapping("/updateNotice")
//    public ResultResponse<List<NoticeDto>> updateNotice() {
//        return noticeService.updateParticipation();
//    }
//
//    @PostMapping("/deleteNotice")
//    public ResultResponse<List<NoticeDto>> deleteNotice() {
//        return noticeService.deleteParticipation();
//    }
}
