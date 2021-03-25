package com.tuya.smart.common;

import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ISubDevListener;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaGateway;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class oO00Oo00 implements ITuyaGateway {
    public final String O000000o;
    public oO000OOO O00000Oo;
    public oO0o0000 O00000o0;

    public oO00Oo00(String str) {
        this.O000000o = str;
        this.O00000Oo = new oO000OOO(TuyaSdk.getApplication(), str);
    }

    public void broadcastDps(String str, IResultCallback iResultCallback) {
        this.O00000Oo.broadcastSend(str, iResultCallback);
    }

    public void getSubDevList(ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        this.O00000Oo.O000000o(this.O000000o, iTuyaDataCallback);
    }

    public void multicastDps(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.multicastSend(str, str2, iResultCallback);
    }

    public void onDestroy() {
        unRegisterSubDevListener();
    }

    public void publishDps(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, str2, iResultCallback);
    }

    public void registerSubDevListener(ISubDevListener iSubDevListener) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new oO0o0000(this.O000000o, iSubDevListener);
        }
    }

    public void unRegisterSubDevListener() {
        oO0o0000 oo0o0000 = this.O00000o0;
        if (oo0o0000 != null) {
            oo0o0000.O000000o();
            this.O00000o0 = null;
        }
    }
}
