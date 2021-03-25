package com.tuya.smart.android.base;

import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.AESUtil;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.security.jni.JNICLibrary;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EncryptApiParams extends ApiParams {
    public static final String TAG = "EncryptApiParams";

    public EncryptApiParams(String str, String str2) {
        super(str, str2);
    }

    public EncryptApiParams(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    private String encryptPostDataString() {
        String postDataString = super.getPostDataString();
        try {
            byte[] encryptPostData = JNICLibrary.encryptPostData(getUrlParams().get(TuyaApiParams.KEY_REQUEST_ID), postDataString.getBytes("UTF-8"));
            AESUtil aESUtil = new AESUtil();
            aESUtil.setALGO(EncryptionManager.O0000ooO);
            aESUtil.setKeyValue(encryptPostData);
            return aESUtil.encryptWithBase64(postDataString);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public Map<String, String> getRequestBody() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hasPostData()) {
            concurrentHashMap.put(TuyaApiParams.KEY_POST, encryptPostDataString());
        }
        return concurrentHashMap;
    }

    public Map<String, String> getRequestSignBody() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (hasPostData()) {
            concurrentHashMap.put(TuyaApiParams.KEY_POST, getPostDataString());
        }
        return concurrentHashMap;
    }

    public String getServerHostUrl() {
        return TuyaSmartNetWork.mApiUrlProvider.getEncrptUrl();
    }

    public Map<String, String> getUrlParams() {
        Map<String, String> urlParams = super.getUrlParams();
        urlParams.remove(TuyaApiParams.KEY_LAT);
        urlParams.remove(TuyaApiParams.KEY_LON);
        return urlParams;
    }
}
