package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.RoomBean;

public interface ITuyaRoomResultCallback {
    void onError(String str, String str2);

    void onSuccess(RoomBean roomBean);
}
