package com.middleware.mobile.domain.common;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    PUBLIC("PUBLIC"),
    PRIVATE("PRIVATE"),
    ONLY_FRIEND("FRIEND"),
    ACTIVE("ACTIVE"),
    DISABLE("DISABLE"),
    DELETE("DELETE"),
    OWNER("OWNER");

    private final String value;
}
