package com.tuya.smart.common;

import a.e.a.a.r.a;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;

public class o00oo0ooo0 {
    public static TuyaSigMeshBean O000000o(SigMeshBean sigMeshBean, SearchDeviceBean searchDeviceBean, DeviceBean deviceBean) {
        String str;
        String str2;
        if (deviceBean != null) {
            str2 = deviceBean.getNodeId();
            str = deviceBean.getDevKey();
        } else {
            str2 = "00";
            str = "";
        }
        TuyaSigMeshBean tuyaSigMeshBean = new TuyaSigMeshBean(sigMeshBean, ProvisionedMeshNode.createDefaultMeshNode(searchDeviceBean.getMeshName(), searchDeviceBean.getMacAdress(), sigMeshBean.getName(), a.c(str2), o00o0000oo.O000000o(str), o00o0000oo.O000000o(sigMeshBean.getMeshkey())));
        tuyaSigMeshBean.setMacAdress(searchDeviceBean.getMacAdress());
        tuyaSigMeshBean.setStatus(searchDeviceBean.getStatus());
        return tuyaSigMeshBean;
    }

    public static o00o0o00oo O000000o(o00o0o00oo o00o0o00oo, SearchDeviceBean searchDeviceBean) {
        o00o0o00oo.O00000Oo(searchDeviceBean.getVendorId());
        o00o0o00oo.O000000o(searchDeviceBean.getMacAdress());
        o00o0o00oo.O000000o(searchDeviceBean.getSessionKey());
        o00o0o00oo.O000000o(searchDeviceBean.getStatus());
        return o00o0o00oo;
    }
}
