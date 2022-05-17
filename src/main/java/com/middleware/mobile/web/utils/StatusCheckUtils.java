package com.middleware.mobile.web.utils;

import com.middleware.mobile.domain.common.Status;

public class StatusCheckUtils {

    private StatusCheckUtils() {}

    public static boolean isDeleted(char value) {
        if (value == 'Y') {
            return true;
        } else {
            return false;
        }
    }

//    public static boolean isDeleted(String value) {
//        if (!MobileValidationUtils.illegalStringValue(value)) {
//            return value.equals(Status.DELETE);
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean isPublic(String value) {
//        if (!MobileValidationUtils.illegalStringValue(value)) {
//            return value.equals(Status.PUBLIC);
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean isPrivate(String value) {
//        if (!MobileValidationUtils.illegalStringValue(value)) {
//            return value.equals(Status.PRIVATE);
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean isOwner(String value) {
//        if (!MobileValidationUtils.illegalStringValue(value)) {
//            return value.equals(Status.OWNER);
//        } else {
//            return false;
//        }
//    }
}
