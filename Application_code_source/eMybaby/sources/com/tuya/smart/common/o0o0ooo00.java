package com.tuya.smart.common;

import com.tuya.smart.home.sdk.api.ITuyaRoom;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.List;

public class o0o0ooo00 implements ITuyaRoom {
    public long O000000o;
    public o0o0o0o00 O00000Oo;
    public List<GroupBean> O00000o;
    public List<DeviceBean> O00000o0;

    public o0o0ooo00(long j) {
        this.O000000o = j;
        this.O00000Oo = new o0o0o0o0o(j);
    }

    public List<DeviceBean> O000000o() {
        return this.O00000o0;
    }

    public List<GroupBean> O00000Oo() {
        return this.O00000o;
    }

    public void addDevice(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, iResultCallback);
    }

    public void addGroup(long j, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(Long.valueOf(j), iResultCallback);
    }

    public void moveDevGroupListFromRoom(List<DeviceAndGroupInRoomBean> list, IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(list, iResultCallback);
    }

    public void removeDevice(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000o0(str, iResultCallback);
    }

    public void removeGroup(Long l, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(l, iResultCallback);
    }

    public void sortDevInRoom(List<DeviceAndGroupInRoomBean> list, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o((Object) list, iResultCallback);
    }

    public void updateRoom(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, iResultCallback);
    }
}
