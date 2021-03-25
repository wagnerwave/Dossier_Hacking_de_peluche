package com.tuya.smart.android.user.api;

import com.tuya.smart.android.user.bean.CommonConfigBean;

public interface ICommonConfigCallback {
    void onError(String str, String str2);

    void onSuccess(CommonConfigBean commonConfigBean);
}
