package com.tuya.smart.android.network.request;

import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.TuyaApiParams;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OKHttpBusinessRequest {
    public static final String TAG = "OKHttpBusinessRequest";

    public interface ApiRequest {
        Map<String, String> getRequestBody();

        String getRequestKey();

        String getRequestUrl();

        boolean shouldCache();

        boolean throwCache();
    }

    public static FormBody getRequestBody(TuyaApiParams tuyaApiParams) {
        Map<String, String> requestBody = tuyaApiParams.getRequestBody();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry next : requestBody.entrySet()) {
            builder.add((String) next.getKey(), (String) next.getValue());
        }
        return builder.build();
    }

    public static Request newOKHttpRequest(TuyaApiParams tuyaApiParams, Map<String, String> map) {
        return newOKHttpRequest(tuyaApiParams, map, (String) null);
    }

    public static Request newOKHttpRequest(TuyaApiParams tuyaApiParams, Map<String, String> map, String str) {
        Request.Builder builder = new Request.Builder();
        if (!TextUtils.isEmpty(str)) {
            builder.tag(str);
        }
        for (Map.Entry next : map.entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        String requestUrl = tuyaApiParams.getRequestUrl();
        L.d(TAG, requestUrl);
        builder.url(requestUrl);
        builder.post(tuyaApiParams.getDataBytes() != null ? RequestBody.create(MediaType.parse("audio"), tuyaApiParams.getDataBytes()) : getRequestBody(tuyaApiParams));
        return builder.build();
    }
}
