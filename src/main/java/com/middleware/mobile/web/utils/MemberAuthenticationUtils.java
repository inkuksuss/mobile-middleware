package com.middleware.mobile.web.utils;

import com.middleware.mobile.domain.common.Authority;
import com.middleware.mobile.domain.dto.SessionDto;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

import static com.middleware.mobile.web.utils.MobileValidationUtils.*;

@Slf4j
public class MemberAuthenticationUtils {

    private MemberAuthenticationUtils() {}

    public static boolean isLogin(HttpSession session) {
        return session != null;
    }

    public static SessionDto getLoginMember(HttpSession session) {
        if (isLogin(session)) {
            return (SessionDto) session.getAttribute(Authority.MEMBER.name());
        } else {
            throw new IllegalStateException("인증되지 않은 유저입니다.");
        }
    }

    public static Long getLoginMemberId(HttpSession session) {
        if (isLogin(session)) {
            SessionDto sessionDto = (SessionDto) session.getAttribute(Authority.MEMBER.name());
            if (isExist(sessionDto.getMemberId())) {
                return sessionDto.getMemberId();
            } else {
                throw new IllegalStateException("인증되지 않은 유저입니다.");
            }
        } else {
            throw new IllegalStateException("인증되지 않은 유저입니다.");
        }
    }

}
