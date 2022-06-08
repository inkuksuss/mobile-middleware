package com.middleware.mobile.web.controller;

import com.middleware.mobile.domain.dto.CategoryDto;
import com.middleware.mobile.domain.dto.ChannelDto;
import com.middleware.mobile.domain.request.channel.AddChannelForm;
import com.middleware.mobile.domain.request.channel.GetChannelForm;
import com.middleware.mobile.domain.request.channel.UpdateChannelForm;
import com.middleware.mobile.domain.response.ResultCode;
import com.middleware.mobile.domain.response.ResultResponse;
import com.middleware.mobile.web.service.CategoryService;
import com.middleware.mobile.web.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.middleware.mobile.web.utils.MemberAuthenticationUtils.getLoginMemberId;
import static com.middleware.mobile.web.utils.MobileValidationUtils.isExist;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResultResponse<List<CategoryDto>> getCategoryList() throws Exception {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setType("PUBLIC");

        List<CategoryDto> categoryList = categoryService.getCategoryList(categoryDto);

        return new ResultResponse<>(HttpStatus.OK, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), categoryList);
    }

//    @PostMapping("/insertCategory")
//    public ResultResponse<List<ChannelDto>> insertCategoryList(AddChannelForm form, HttpSession session) throws Exception {
//        ChannelDto channelDto = new ChannelDto();
//        Long loginMemberId = getLoginMemberId(session);
//        if (isExist(loginMemberId)) {
//            channelDto.setMemberId(loginMemberId);
//        }
//        if (isExist(form.getChannelName())) {
//            channelDto.setChannelName(form.getChannelName());
//        }
//        if (isExist(form.getChannelState())) {
//            channelDto.setChannelState(form.getChannelState());
//        }
//        return channelService.insertChannel(channelDto);
//    }
//
//    @PostMapping("/updateCategory")
//    public ResultResponse<List<ChannelDto>> updateCategory(UpdateChannelForm form, HttpSession session) throws Exception {
//        ChannelDto channelDto = new ChannelDto();
//        Long loginMemberId = getLoginMemberId(session);
//        if (isExist(loginMemberId)) {
//            channelDto.setLoginMemberId(loginMemberId);
//        }
//        if (isExist(form.getChannelName())) {
//            channelDto.setChannelName(form.getChannelName());
//        }
//        if (isExist(form.getChannelState())) {
//            channelDto.setChannelState(form.getChannelState());
//        }
//        return channelService.updateChannel(channelDto);
//    }
//
//    @GetMapping("/deleteCategory/{categoryId}")
//    public ResultResponse<List<ChannelDto>> deleteChannel(@PathVariable Long channelId, HttpSession session) throws Exception {
//        ChannelDto channelDto = new ChannelDto();
//        Long loginMemberId = getLoginMemberId(session);
//        if (isExist(loginMemberId)) {
//            channelDto.setLoginMemberId(loginMemberId);
//        }
//        if (isExist(channelId)) {
//            channelDto.setChannelId(channelId);
//        }
//        return channelService.deleteChannel(channelDto);
//    }
}
