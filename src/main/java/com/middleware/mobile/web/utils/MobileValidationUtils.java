package com.middleware.mobile.web.utils;


public class MobileValidationUtils {

    private MobileValidationUtils() {}

    public static boolean isExist(Long value) {
        return value != null && value > 0;
    }

    public static boolean isExist(String value) {
        return value != null && !value.trim().equals("");
    }
}
