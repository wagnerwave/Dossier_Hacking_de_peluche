package com.tuya.smart.android.base;

import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.oo000o0o0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataBytesApiParams extends ApiParams {
    public DataBytesApiParams(String str, String str2) {
        super(str, str2);
    }

    public Map<String, String> getRequestBody() {
        return super.getRequestBody();
    }

    public String getRequestUrl() {
        Map<String, String> urlParams = getUrlParams();
        urlParams.put("time", String.valueOf(TimeStampManager.instance().getCurrentTimeStamp()));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(urlParams);
        concurrentHashMap.putAll(getRequestSignBody());
        urlParams.put(TuyaApiParams.KEY_POST, getRequestBody().get(TuyaApiParams.KEY_POST));
        urlParams.put("sign", oo000o0o0.O000000o(concurrentHashMap, this));
        return oo000o0o0.O000000o(true, getServerHostUrl(), urlParams);
    }

    public String getServerHostUrl() {
        return TuyaSmartNetWork.mApiUrlProvider.getAudioUrl();
    }

    public void initUrlParams(String str) {
        super.initUrlParams(str);
    }
}
