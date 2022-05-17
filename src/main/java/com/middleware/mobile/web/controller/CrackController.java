package com.middleware.mobile.web.controller;


import com.middleware.mobile.domain.dto.CrackDto;
import com.middleware.mobile.domain.request.crack.AddCrackForm;
import com.middleware.mobile.domain.request.crack.GetCrackForm;
import com.middleware.mobile.domain.request.crack.UpdateCrackForm;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.member.CrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@RestController
@RequestMapping("/crack")
@RequiredArgsConstructor
public class CrackController {

    private final CrackService crackService;

    @PostMapping("/getCrack")
    public ResultResponse<List<CrackDto>> getCrackList(@RequestBody GetCrackForm form) throws Exception {
        CrackDto crackDto = new CrackDto();
        if (isExist(form.getCrackId())) {
            crackDto.setCrackId(form.getCrackId());
        }
        if (isExist(form.getChannelId())) {
            crackDto.setChannelId(form.getChannelId());
        }
        if (isExist(form.getMemberId())) {
            crackDto.setMemberId(form.getMemberId());
        }
        if (isExist(form.getCrackStatus())) {
            crackDto.setCrackStatus(form.getCrackStatus());
        }
        if (isExist(form.getCrackName())) {
            crackDto.setCrackName(form.getCrackName());
        }
        return crackService.getCrackList(crackDto);
    }

    @PostMapping("/insertCrack")
    public ResultResponse<CrackDto> insertCrack(@RequestBody AddCrackForm form) throws Exception {
        CrackDto crackDto = new CrackDto();
        if (isExist(form.getCrackName())) {
            crackDto.setCrackName(crackDto.getCrackName());
        }
        if (isExist(form.getChannelId())) {
            crackDto.setChannelId(crackDto.getChannelId());
        }
        if (isExist(form.getCrackStatus())) {
            crackDto.setCrackStatus(form.getCrackStatus());
        }
        return crackService.insertCrack(crackDto);
    }

    @PostMapping("/updateCrack")
    public ResultResponse<CrackDto> updateCrack(@RequestBody UpdateCrackForm form) throws Exception {
        CrackDto crackDto = new CrackDto();
        if (isExist(form.getCrackId())) {
            crackDto.setCrackId(form.getCrackId());
        }
        if (isExist(form.getCrackName())) {
            crackDto.setCrackName(form.getCrackName());
        }
        if (isExist(form.getCrackStatus())) {
            crackDto.setCrackStatus(form.getCrackStatus());
        }
        return crackService.updateCrack(crackDto);
    }

    @GetMapping("/deleteCrack/{crackId}")
    public ResultResponse<CrackDto> deleteCrack(@PathVariable Long crackId) throws Exception {
        CrackDto crackDto = new CrackDto();
        if (isExist(crackId)) {
            crackDto.setCrackId(crackId);
        }
        return crackService.deleteCrack(crackDto);
    }
}
