package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.WiFiUtil;
import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.common.O00000o0;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshActivatorListener;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMeshActivator;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O000O0OO extends BasePresenter implements o0o00ooo0o, ITuyaBlueMeshActivator {
    public static final String O00000Oo = "TuyaBlueMeshActivatorStatusImpl";
    public long O000000o;
    public final o0o00ooo00 O00000o;
    public final IBlueMeshActivatorListener O00000o0;
    public o0oo0o0ooo O00000oO = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public String O00000oo;

    public O000O0OO(String str, IBlueMeshActivatorListener iBlueMeshActivatorListener) {
        this.O00000oo = str;
        this.O00000o0 = iBlueMeshActivatorListener;
        this.O00000o = ((o0o00o000o) Oo0.O000000o(o0o00o000o.class)).O000000o(TuyaSdk.getApplication(), str, this);
    }

    /* access modifiers changed from: private */
    public Map<String, Object> O000000o() {
        HashMap r = a.r("type", O00000o0.C0104O00000o0.O000000o);
        if (!TextUtils.isEmpty(this.O00000oo)) {
            r.put("token", this.O00000oo);
        }
        r.put("bssid", WiFiUtil.getBssid(TuyaSdk.getApplication()));
        return r;
    }

    public void O000000o(GwDevResp gwDevResp) {
        ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000Ooo().O000000o(gwDevResp.getGwId(), (ITuyaDataCallback<DeviceBean>) new ITuyaDataCallback<DeviceBean>() {
            /* renamed from: O000000o */
            public void onSuccess(DeviceBean deviceBean) {
                if (O000O0OO.this.O00000o0 != null) {
                    O000O0OO.this.O00000o0.onSuccess(deviceBean);
                }
                long currentTimeMillis = System.currentTimeMillis();
                HashMap r = a.r("type", O00000o0.C0104O00000o0.O000000o);
                r.put("time", Long.valueOf((currentTimeMillis - O000O0OO.this.O000000o) / 1000));
                if (O000O0OO.this.O00000oO != null) {
                    O000O0OO.this.O00000oO.O000000o(O00000o0.O000000o.O000000o, r);
                }
            }

            public void onError(String str, String str2) {
                if (O000O0OO.this.O00000o0 != null) {
                    O000O0OO.this.O00000o0.onFailure(str, str2);
                }
                Map O00000o0 = O000O0OO.this.O000000o();
                O00000o0.put("step", "update_device");
                if (O000O0OO.this.O00000oO != null) {
                    O000O0OO.this.O00000oO.O000000o("f22f53893cedc95aa34844b792f341ba", O00000o0);
                }
            }
        });
        stopActivator();
    }

    public void O000000o(List<GwDevResp> list) {
        IBlueMeshActivatorListener iBlueMeshActivatorListener = this.O00000o0;
        if (iBlueMeshActivatorListener != null) {
            iBlueMeshActivatorListener.onStep("device_find", list.get(0).getGwId());
        }
    }

    public void O00000Oo(List<ConfigErrorRespBean> list) {
        IBlueMeshActivatorListener iBlueMeshActivatorListener = this.O00000o0;
        if (iBlueMeshActivatorListener != null) {
            iBlueMeshActivatorListener.onFailure("find_error", JSON.toJSONString(list));
        }
        Map<String, Object> O000000o2 = O000000o();
        O000000o2.put("step", "activate");
        o0oo0o0ooo o0oo0o0ooo = this.O00000oO;
        if (o0oo0o0ooo != null) {
            o0oo0o0ooo.O000000o("f22f53893cedc95aa34844b792f341ba", O000000o2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        L.d(O00000Oo, "onDestroy");
        this.O00000o.onDestroy();
    }

    public void startActivator() {
        L.d(O00000Oo, "start");
        this.O00000o.O00000Oo();
        this.O000000o = System.currentTimeMillis();
        if (this.O00000oO != null) {
            this.O00000oO.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", a.r("type", O00000o0.C0104O00000o0.O000000o));
        }
    }

    public void stopActivator() {
        L.d(O00000Oo, "stop");
        onDestroy();
    }
}
