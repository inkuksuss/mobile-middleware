package com.middleware.mobile.web.utils;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.SessionDto;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
public class MemberAuthenticationUtils {

    private MemberAuthenticationUtils() {}

    public static boolean isLogin(HttpSession session) {
        if (session == null) {
            return false;
        } else {
            return true;
        }
    }

    public static SessionDto getLoginMember(HttpSession session) {
        return (SessionDto) session.getAttribute(Authority.MEMBER.name());
    }

}
