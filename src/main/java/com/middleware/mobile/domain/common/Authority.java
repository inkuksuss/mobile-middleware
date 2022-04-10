package com.middleware.mobile.domain.common;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {

    MEMBER('M'),
    ADMIN('A'),
    ANONYMOUS('Y');

    private final char value;
}
