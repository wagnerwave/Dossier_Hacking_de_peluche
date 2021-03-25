package com.tuya.smart.sdk.api;

import java.util.Map;

public interface ITuyaSmartRequest {
    void onDestroy();

    @Deprecated
    void requestWithApiName(String str, String str2, Map<String, Object> map, IRequestCallback iRequestCallback);

    <T> void requestWithApiName(String str, String str2, Map<String, Object> map, Class<T> cls, ITuyaDataCallback<T> iTuyaDataCallback);

    @Deprecated
    void requestWithApiNameWithoutSession(String str, String str2, Map<String, Object> map, IRequestCallback iRequestCallback);

    <T> void requestWithApiNameWithoutSession(String str, String str2, Map<String, Object> map, Class<T> cls, ITuyaDataCallback<T> iTuyaDataCallback);
}
