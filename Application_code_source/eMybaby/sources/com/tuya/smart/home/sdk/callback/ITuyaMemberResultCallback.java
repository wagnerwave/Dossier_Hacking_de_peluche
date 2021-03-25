package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.MemberBean;

public interface ITuyaMemberResultCallback {
    void onError(String str, String str2);

    void onSuccess(MemberBean memberBean);
}
