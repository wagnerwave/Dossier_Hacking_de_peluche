package com.tuya.smart.common;

import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.IRequestCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaSmartRequest;
import java.util.Map;

public class ooOOO0Oo implements ITuyaSmartRequest {
    public static volatile ooOOO0Oo O000000o;
    public o000 O00000Oo = new o000();

    public static ooOOO0Oo O000000o() {
        if (O000000o == null) {
            synchronized (ooOOO0Oo.class) {
                if (O000000o == null) {
                    O000000o = new ooOOO0Oo();
                }
            }
        }
        return O000000o;
    }

    public void onDestroy() {
        this.O00000Oo.onDestroy();
    }

    public void requestWithApiName(String str, String str2, Map<String, Object> map, final IRequestCallback iRequestCallback) {
        this.O00000Oo.O000000o(str, str2, map, (Business.ResultListener<Object>) new Business.ResultListener<Object>() {
            public void onFailure(BusinessResponse businessResponse, Object obj, String str) {
                IRequestCallback iRequestCallback = iRequestCallback;
                if (iRequestCallback != null) {
                    iRequestCallback.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            public void onSuccess(BusinessResponse businessResponse, Object obj, String str) {
                IRequestCallback iRequestCallback = iRequestCallback;
                if (iRequestCallback != null) {
                    iRequestCallback.onSuccess(obj);
                }
            }
        });
    }

    public <T> void requestWithApiName(String str, String str2, Map<String, Object> map, Class<T> cls, final ITuyaDataCallback<T> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, str2, map, cls, true, new Business.ResultListener<T>() {
            public void onFailure(BusinessResponse businessResponse, T t, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            public void onSuccess(BusinessResponse businessResponse, T t, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(t);
                }
            }
        });
    }

    public void requestWithApiNameWithoutSession(String str, String str2, Map<String, Object> map, final IRequestCallback iRequestCallback) {
        this.O00000Oo.O00000Oo(str, str2, map, (Business.ResultListener<Object>) new Business.ResultListener<Object>() {
            public void onFailure(BusinessResponse businessResponse, Object obj, String str) {
                IRequestCallback iRequestCallback = iRequestCallback;
                if (iRequestCallback != null) {
                    iRequestCallback.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            public void onSuccess(BusinessResponse businessResponse, Object obj, String str) {
                IRequestCallback iRequestCallback = iRequestCallback;
                if (iRequestCallback != null) {
                    iRequestCallback.onSuccess(obj);
                }
            }
        });
    }

    public <T> void requestWithApiNameWithoutSession(String str, String str2, Map<String, Object> map, Class<T> cls, final ITuyaDataCallback<T> iTuyaDataCallback) {
        this.O00000Oo.O000000o(str, str2, map, cls, false, new Business.ResultListener<T>() {
            public void onFailure(BusinessResponse businessResponse, T t, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            public void onSuccess(BusinessResponse businessResponse, T t, String str) {
                ITuyaDataCallback iTuyaDataCallback = iTuyaDataCallback;
                if (iTuyaDataCallback != null) {
                    iTuyaDataCallback.onSuccess(t);
                }
            }
        });
    }
}
