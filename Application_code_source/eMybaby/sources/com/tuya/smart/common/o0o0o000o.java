package com.tuya.smart.common;

import com.tuya.smart.home.sdk.bean.DeviceAndGroupInHomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetRoomListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaRoomResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import java.util.List;

public interface o0o0o000o {
    List<RoomBean> O000000o(List<DeviceBean> list);

    void O000000o(long j, IResultCallback iResultCallback);

    void O000000o(long j, String str, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    void O000000o(long j, String str, String str2, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    void O000000o(ITuyaGetRoomListCallback iTuyaGetRoomListCallback);

    void O000000o(ITuyaHomeResultCallback iTuyaHomeResultCallback);

    void O000000o(IResultCallback iResultCallback);

    void O000000o(String str, double d2, double d3, String str2, IResultCallback iResultCallback);

    void O000000o(String str, double d2, double d3, String str2, List<String> list, boolean z, IResultCallback iResultCallback);

    void O000000o(String str, ITuyaRoomResultCallback iTuyaRoomResultCallback);

    void O000000o(String str, List<DeviceAndGroupInHomeBean> list, IResultCallback iResultCallback);

    void O000000o(List<Long> list, IResultCallback iResultCallback);

    List<RoomBean> O00000Oo(List<GroupBean> list);

    void O00000Oo(List<Long> list, IResultCallback iResultCallback);

    void O00000o0(List<String> list, IResultCallback iResultCallback);
}
