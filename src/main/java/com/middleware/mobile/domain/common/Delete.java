package com.middleware.mobile.domain.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Delete {

    DELETE('Y'),
    EXIST('N');

    private final char value;
}
