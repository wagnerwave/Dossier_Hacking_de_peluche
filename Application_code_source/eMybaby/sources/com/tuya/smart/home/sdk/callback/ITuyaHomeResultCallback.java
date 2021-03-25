package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.HomeBean;

public interface ITuyaHomeResultCallback {
    void onError(String str, String str2);

    void onSuccess(HomeBean homeBean);
}
