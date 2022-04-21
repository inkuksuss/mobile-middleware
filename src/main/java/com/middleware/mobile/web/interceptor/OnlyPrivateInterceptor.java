package com.middleware.mobile.web.interceptor;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.SessionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Slf4j
public class OnlyPrivateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        SessionDto sessionDto = (SessionDto) session.getAttribute(Authority.MEMBER.name());

        boolean hasMemberId = false;
        boolean hasMemberName = false;
        boolean hasMemberEmail = false;
        boolean hasMemberAuthority = false;

        if (sessionDto.getMemberId() != null && sessionDto.getMemberId() > 0) {
            hasMemberId = true;
        }

        if (sessionDto.getMemberName() != null && !sessionDto.getMemberName().trim().equals("")) {
            hasMemberName = true;
        }

        if (sessionDto.getMemberEmail() != null && !sessionDto.getMemberEmail().trim().equals("")) {
            hasMemberEmail = true;
        }

        if (sessionDto.getMemberAuthority() != ' ') {
            hasMemberAuthority = true;
        }

        return hasMemberId && hasMemberName && hasMemberEmail && hasMemberAuthority;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
