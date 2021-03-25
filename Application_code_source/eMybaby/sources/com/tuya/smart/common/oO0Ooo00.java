package com.tuya.smart.common;

import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;

public class oO0Ooo00 extends Business {
    public static String O000000o = "atop.online.debug.log";
    public static String O00000Oo = "tuya.m.log.report";

    public void O000000o(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "2.0");
        apiParams.putPostData("data", str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }

    public void O00000Oo(String str, Business.ResultListener<Boolean> resultListener) {
        ApiParams apiParams = new ApiParams(O000000o, "1.0");
        apiParams.putPostData("data", str);
        apiParams.setSessionRequire(true);
        asyncRequest(apiParams, Boolean.class, resultListener);
    }
}
