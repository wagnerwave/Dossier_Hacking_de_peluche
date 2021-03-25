package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.RoomBean;
import java.util.List;

public interface ITuyaGetRoomListCallback {
    void onError(String str, String str2);

    void onSuccess(List<RoomBean> list);
}
