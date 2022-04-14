package com.middleware.mobile.web.utils;


public class FormValidationUtils {

    private FormValidationUtils() {}

    public static boolean illegalLongValue(Long value) {
        if (value == null && value <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean illegalLongValues(Long[] values) {

        boolean result = false;

        for (Long value : values) {
            if (value == null || value <= 0) {
                result = true;
            }
        }

        return result;
    }

    public static boolean illegalStringValue(String value) {
        if (value != null && value.trim() != "") {
            return false;
        } else {
            return true;
        }
    }
}
