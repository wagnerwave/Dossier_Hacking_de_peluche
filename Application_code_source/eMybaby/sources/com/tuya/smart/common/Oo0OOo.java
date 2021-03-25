package com.tuya.smart.common;

import a.e.a.a.r.a;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.TuyaBlueMeshActivatorBuilder;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.sdk.api.ITuyaActivatorGetToken;
import com.tuya.smart.sdk.bean.DeviceBean;

public class Oo0OOo extends O0o0 {
    public static final String O0000Oo = "TuyaBlueMeshWifiActivatorImpl2";
    public O0o0000 O0000OoO = new O0o0000();

    public Oo0OOo(TuyaBlueMeshActivatorBuilder tuyaBlueMeshActivatorBuilder) {
        super(tuyaBlueMeshActivatorBuilder);
    }

    public void O000000o() {
        this.O000000o = O00Oo00.O00000Oo(new O00o00().O000000o(this.O00000Oo.getMeshOriginName()).O00000Oo(this.O00000Oo.getMeshOriginPassword()).O00000o0(this.O00000o0.getName()).O00000o(this.O00000o0.getPassword()).O000000o(this.O00000Oo.getTimeOut()).O000000o(this.O00000Oo.getSearchDeviceBeans()).O00000oO(this.O00000Oo.getWifiSsid()).O00000oo(this.O00000Oo.getWifiPassword()).O000000o(this.O0000Oo0));
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, final ooooooo ooooooo) {
        String d2 = a.d(searchDeviceBean.getMeshAddress());
        String a2 = a.a(searchDeviceBean.getProductId());
        String version = searchDeviceBean.getVersion();
        StringBuilder q = a.a.a.a.a.q("nodeId: ", d2, " md5:");
        q.append(o000000o.O00000Oo());
        q.append("  productId:  ");
        q.append(a2);
        q.append("  version:");
        q.append(version);
        L.d(O0000Oo, q.toString());
        this.O00000o.O000000o(this.O00000Oo.getHomeId(), a2, this.O00000o0.getMeshId(), d2, o000000o.O00000o0(), o000000o.O00000Oo(), version, new ITuyaActivatorGetToken() {
            public void onFailure(String str, String str2) {
                L.d(Oo0OOo.O0000Oo, "configWifiInfo onFailure " + str + " " + str2);
                ooooooo.O000000o(str, str2);
            }

            public void onSuccess(String str) {
                L.d(Oo0OOo.O0000Oo, "configWifiInfo onSuccess");
                ooooooo.O000000o(str);
            }
        });
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, String str, final O0O000o o0O000o) {
        this.O0000OoO.O000000o(str, new O0Oo000() {
            public void O000000o(DeviceBean deviceBean) {
                Oo0OOo.this.O0000OOo.put(searchDeviceBean.getMacAdress(), deviceBean);
                new O0OOo().O000000o(deviceBean.getDevId());
                o0O000o.O000000o();
            }

            public void O000000o(String str, String str2) {
                o0O000o.O000000o(str, str2);
            }
        });
    }

    public void stopActivator() {
        super.stopActivator();
        this.O0000OoO.O000000o();
    }
}
