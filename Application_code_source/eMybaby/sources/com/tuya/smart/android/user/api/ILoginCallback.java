package com.tuya.smart.android.user.api;

import com.tuya.smart.android.user.bean.User;

public interface ILoginCallback {
    void onError(String str, String str2);

    void onSuccess(User user);
}
