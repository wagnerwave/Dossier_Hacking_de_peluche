package com.tuya.smart.common;

import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;

public class oo000oo00 extends Business {
    public static final String O000000o = "tuya.p.time.get";

    public void O000000o(Business.ResultListener<Long> resultListener) {
        TuyaApiParams tuyaApiParams = new TuyaApiParams(O000000o, "1.0");
        tuyaApiParams.setSessionRequire(false);
        asyncRequest(tuyaApiParams, Long.class, "time", resultListener);
    }
}
