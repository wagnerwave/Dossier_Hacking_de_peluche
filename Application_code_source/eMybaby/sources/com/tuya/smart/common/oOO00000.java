package com.tuya.smart.common;

import com.tuya.smart.home.sdk.callback.ITuyaVoiceTransfer;
import com.tuya.smart.sdk.api.ITuyaGetBeanCallback;
import com.tuya.smart.sdk.bean.SpeechTTSBean;
import java.util.ArrayList;
import java.util.List;

public class oOO00000 implements o0o0o00000, ITuyaVoiceTransfer {
    public o0o00o00o0 O000000o;
    public List<ITuyaGetBeanCallback<SpeechTTSBean>> O00000Oo;

    public static class O000000o {
        public static oOO00000 O000000o = new oOO00000();
    }

    public oOO00000() {
        this.O000000o = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        this.O00000Oo = new ArrayList();
    }

    public static oOO00000 O000000o() {
        return O000000o.O000000o;
    }

    public void onConnect() {
        o0o00o00o0 o0o00o00o0 = this.O000000o;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0oo000000.class, this);
        }
    }

    public void onDestroy() {
        o0o00o00o0 o0o00o00o0 = this.O000000o;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(SpeechTTSBean.class, this);
        }
    }

    public void onResult(Object obj) {
        o0oo000000 o0oo000000;
        if ((obj instanceof o0oo000000) && this.O00000Oo != null && (o0oo000000 = (o0oo000000) obj) != null) {
            SpeechTTSBean speechTTSBean = new SpeechTTSBean(o0oo000000.O000000o(), o0oo000000.O00000Oo(), o0oo000000.O00000o0(), o0oo000000.O00000o(), o0oo000000.O00000oO(), o0oo000000.O00000oo());
            for (ITuyaGetBeanCallback<SpeechTTSBean> onResult : this.O00000Oo) {
                onResult.onResult(speechTTSBean);
            }
        }
    }

    public void subscribeServer(ITuyaGetBeanCallback<SpeechTTSBean> iTuyaGetBeanCallback) {
        List<ITuyaGetBeanCallback<SpeechTTSBean>> list = this.O00000Oo;
        if (list != null && iTuyaGetBeanCallback != null && !list.contains(iTuyaGetBeanCallback)) {
            this.O00000Oo.add(iTuyaGetBeanCallback);
        }
    }

    public void unSubscribeServer(ITuyaGetBeanCallback<SpeechTTSBean> iTuyaGetBeanCallback) {
        List<ITuyaGetBeanCallback<SpeechTTSBean>> list = this.O00000Oo;
        if (list != null && iTuyaGetBeanCallback != null && list.contains(iTuyaGetBeanCallback)) {
            this.O00000Oo.remove(iTuyaGetBeanCallback);
        }
    }
}
