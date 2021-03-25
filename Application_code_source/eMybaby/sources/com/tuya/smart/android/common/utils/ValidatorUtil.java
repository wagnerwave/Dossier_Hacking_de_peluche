package com.tuya.smart.android.common.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class ValidatorUtil {
    public static boolean check(String str, Pattern pattern) {
        try {
            return pattern.matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEmail(String str) {
        return !TextUtils.isEmpty(str) && str.contains("@") && str.contains(".");
    }
}
