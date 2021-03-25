package com.tuya.smart.android.common.utils;

import com.tuya.smart.android.base.utils.PreferencesUtil;
import java.util.HashMap;

public class LogUtils {
    public static String logServer(String str, HashMap<String, Object> hashMap) {
        return EncyptionUtils.encryptAes(new LogBean(str, hashMap).formatLog(), PreferencesUtil.getGlobalPrefrencesKey("log"));
    }
}
