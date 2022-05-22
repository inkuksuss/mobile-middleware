package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.dto.ParticipationDto;
import com.middleware.mobile.domain.request.particaption.AddParticipationForm;
import com.middleware.mobile.domain.request.particaption.DeleteParticipationForm;
import com.middleware.mobile.domain.request.particaption.UpdateParticipationForm;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.ParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.middleware.mobile.web.utils.MemberAuthenticationUtils.*;
import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participation")
public class ParticipationController {

    private final ParticipationService participationService;

    @GetMapping("/{channelId}")
    public ResultResponse<List<ParticipationDto>> getParticipationList(@PathVariable Long channelId) throws Exception {
        ParticipationDto participationDto = new ParticipationDto();
        if (isExist(channelId)) {
            participationDto.setChannelId(channelId);
        }
        return participationService.getParticipationList(participationDto);
    }

    @PostMapping("/insertParticipation")
    public ResultResponse<List<ParticipationDto>> insertParticipation(AddParticipationForm form, HttpSession session) throws Exception {
        ParticipationDto participationDto = new ParticipationDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(form.getChannelId())) {
            participationDto.setChannelId(form.getChannelId());
        }
        if (isExist(form.getMemberId())) {
            participationDto.setMemberId(form.getMemberId());
        }
        if (isExist(form.getParticipationAuthority())) {
            participationDto.setParticipationAuthority(form.getParticipationAuthority());
        }
        participationDto.setLoginMemberId(loginMemberId);

        return participationService.insertParticipation(participationDto);
    }

    @PostMapping("/updateParticipation")
    public ResultResponse<List<ParticipationDto>> updateParticipation(UpdateParticipationForm form, HttpSession session) throws Exception {
        ParticipationDto participationDto = new ParticipationDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(form.getMemberId())) {
            participationDto.setMemberId(form.getMemberId());
        }
        if (isExist(form.getParticipationAuthority())) {
            participationDto.setParticipationAuthority(form.getParticipationAuthority());
        }
        participationDto.setLoginMemberId(loginMemberId);

        return participationService.updateParticipation(participationDto);
    }

    @PostMapping("/deleteParticipation")
    public ResultResponse<List<ParticipationDto>> deleteParticipation(DeleteParticipationForm form, HttpSession session) throws Exception {
        ParticipationDto participationDto = new ParticipationDto();
        Long loginMemberId = getLoginMemberId(session);
        if (isExist(form.getChannelId())) {
            participationDto.setChannelId(form.getChannelId());
        }
        if (isExist(form.getMemberId())) {
            participationDto.setMemberId(form.getMemberId());
        }
        participationDto.setLoginMemberId(loginMemberId);

        return participationService.updateParticipation(participationDto);
    }
}
