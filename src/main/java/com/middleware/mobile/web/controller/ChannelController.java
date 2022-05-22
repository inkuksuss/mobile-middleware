package com.middleware.mobile.web.controller;

import com.middleware.mobile.domain.dto.ChannelDto;
import com.middleware.mobile.domain.request.channel.AddChannelForm;
import com.middleware.mobile.domain.request.channel.GetChannelForm;
import com.middleware.mobile.domain.request.channel.UpdateChannelForm;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.middleware.mobile.web.utils.MemberAuthenticationUtils.*;
import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/channel")
public class ChannelController {

    private final ChannelService channelService;


    @PostMapping("/getChannelList")
    public ResultResponse<List<ChannelDto>> getChannelList(GetChannelForm form) throws Exception {

        ChannelDto channelDto = new ChannelDto();
        if (isExist(form.getChannelId())) {
            channelDto.setChannelId(form.getChannelId());
        }
        if (isExist(form.getMemberId())) {
            channelDto.setMemberId(form.getMemberId());
        }
        if (isExist(form.getChannelName())) {
            channelDto.setChannelName(form.getChannelName());
        }
        if (isExist(form.getChannelState())) {
            channelDto.setChannelState(form.getChannelState());
        }
        return channelService.getChannelList(channelDto);
    }

    @PostMapping("/insertChannel")
    public ResultResponse<List<ChannelDto>> insertChannel(AddChannelForm form, HttpSession session) throws Exception {
        ChannelDto channelDto = new ChannelDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(loginMemberId)) {
            channelDto.setMemberId(loginMemberId);
        }
        if (isExist(form.getChannelName())) {
            channelDto.setChannelName(form.getChannelName());
        }
        if (isExist(form.getChannelState())) {
            channelDto.setChannelState(form.getChannelState());
        }
        return channelService.insertChannel(channelDto);
    }

    @PostMapping("/updateChannel")
    public ResultResponse<List<ChannelDto>> updateChannel(UpdateChannelForm form, HttpSession session) throws Exception {
        ChannelDto channelDto = new ChannelDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(loginMemberId)) {
            channelDto.setLoginMemberId(loginMemberId);
        }
        if (isExist(form.getChannelName())) {
            channelDto.setChannelName(form.getChannelName());
        }
        if (isExist(form.getChannelState())) {
            channelDto.setChannelState(form.getChannelState());
        }
        return channelService.updateChannel(channelDto);
    }

    @PostMapping("/deleteChannel/{channelId}")
    public ResultResponse<List<ChannelDto>> deleteChannel(@PathVariable Long channelId, HttpSession session) throws Exception {
        ChannelDto channelDto = new ChannelDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(loginMemberId)) {
            channelDto.setLoginMemberId(loginMemberId);
        }
        if (isExist(channelId)) {
            channelDto.setChannelId(channelId);
        }
        return channelService.deleteChannel(channelDto);
    }
}
