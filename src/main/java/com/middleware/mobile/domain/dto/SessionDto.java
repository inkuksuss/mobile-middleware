package com.middleware.mobile.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Builder
@Getter
public class SessionDto implements Serializable {

    private final Long memberId;
    private final String memberName;
    private final String memberEmail;
    private final char memberAuthority;
}
