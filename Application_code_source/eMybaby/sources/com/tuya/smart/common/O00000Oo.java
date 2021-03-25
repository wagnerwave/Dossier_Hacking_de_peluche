package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshClient;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshConfig;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshDevice;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshOta;
import com.tuya.smart.android.blemesh.api.ITuyaSigMeshClient;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshOtaBuilder;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshManager;
import com.tuya.smart.sdk.api.bluemesh.IMeshStatusListener;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshManager;
import com.tuya.smart.sdk.bean.DeviceBean;

public class O00000Oo implements o0o000oooo {
    public ITuyaBlueMeshDevice O000000o(String str) {
        return new O0OO0O(str);
    }

    public ITuyaBlueMeshGroup O000000o(long j) {
        return new O0OO0Oo(j);
    }

    public ITuyaBlueMeshGroup O000000o(String str, String str2, String str3) {
        return new O0OOO0(str, str2, str3);
    }

    public ITuyaBlueMeshOta O000000o(TuyaBlueMeshOtaBuilder tuyaBlueMeshOtaBuilder) {
        Class cls = o0o00o00o0.class;
        String devId = tuyaBlueMeshOtaBuilder.getDevId();
        if (Oo0.O000000o(cls) == null) {
            return new OO0oO(tuyaBlueMeshOtaBuilder);
        }
        DeviceBean deviceBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(devId);
        return (deviceBean == null || !deviceBean.isSigMesh()) ? new OO0oO(tuyaBlueMeshOtaBuilder) : new oo0oo00oo(tuyaBlueMeshOtaBuilder);
    }

    public IBlueMeshManager O000000o() {
        return O000OO0o.O000000o();
    }

    public ITuyaBlueMeshDevice O00000Oo(String str) {
        return new oo0oo00o0(str);
    }

    public ITuyaBlueMeshGroup O00000Oo(long j) {
        return new oooo0oooo(j);
    }

    public ISigMeshManager O00000Oo() {
        return ooooo00oo.O000000o();
    }

    public IMeshStatusListener O00000o() {
        return O000O0o.O000000o();
    }

    public void O00000o0() {
        O000OO0o.O000000o().onDestroy();
    }

    public ITuyaBlueMeshClient O00000oO() {
        return O0O0o0.O000000o();
    }

    public ITuyaSigMeshClient O00000oo() {
        return oo0oo0000.O000000o();
    }

    public ITuyaBlueMeshConfig O0000O0o() {
        return new O0OoOo();
    }
}
