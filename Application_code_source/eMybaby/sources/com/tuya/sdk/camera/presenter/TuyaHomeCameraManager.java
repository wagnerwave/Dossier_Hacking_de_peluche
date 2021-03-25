package com.tuya.sdk.camera.presenter;

import com.tuya.smart.android.camera.api.ITuyaHomeCamera;
import com.tuya.smart.android.camera.api.bean.CameraPushDataBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.device.utils.SandRMap;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o0oo0;
import com.tuya.smart.common.o0o0o00000;
import com.tuya.smart.common.o0o0oo0oo0;
import com.tuya.smart.common.o0o0oo0ooo;
import com.tuya.smart.common.o0o0oooo0o;
import com.tuya.smart.common.o0oo00o00o;
import com.tuya.smart.common.o0oo0oo0o0;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGetBeanCallback;

public class TuyaHomeCameraManager implements ITuyaHomeCamera {
    public static final String TAG = "TuyaHomeCameraManager";
    public o0o0o00000<o0o0oo0oo0> mq_302_receiver = new o0o0o00000<o0o0oo0oo0>() {
        public void onResult(o0o0oo0oo0 o0o0oo0oo0) {
            if (TuyaHomeCameraManager.this.mqtt302Callback != null && o0o0oo0oo0 != null && o0o0oo0oo0.O000000o() != null) {
                TuyaHomeCameraManager.this.mqtt302Callback.onResult(o0o0oo0oo0.O000000o().toString());
            }
        }
    };
    public o0o0o00000<o0o0oo0ooo> mq_308_receiver = new o0o0o00000<o0o0oo0ooo>() {
        public void onResult(o0o0oo0ooo o0o0oo0ooo) {
            if (TuyaHomeCameraManager.this.mqtt308Callback != null && o0o0oo0ooo != null && o0o0oo0ooo.O000000o() != null) {
                TuyaHomeCameraManager.this.mqtt308Callback.onResult(o0o0oo0ooo.O000000o().toString());
            }
        }
    };
    public o0o0o00000<o0o0oooo0o> mq_43_receiver = new o0o0o00000<o0o0oooo0o>() {
        public void onResult(o0o0oooo0o o0o0oooo0o) {
            CameraPushDataBean cameraPushDataBean = new CameraPushDataBean();
            cameraPushDataBean.setDevId(o0o0oooo0o.O000000o());
            cameraPushDataBean.setEdata(o0o0oooo0o.O00000o());
            cameraPushDataBean.setEtype(o0o0oooo0o.O00000o0());
            cameraPushDataBean.setTimestamp(o0o0oooo0o.O00000Oo());
            if (TuyaHomeCameraManager.this.mqtt43Callback != null) {
                TuyaHomeCameraManager.this.mqtt43Callback.onResult(cameraPushDataBean);
            }
        }
    };
    public ITuyaGetBeanCallback<String> mqtt302Callback;
    public ITuyaGetBeanCallback<String> mqtt308Callback;
    public ITuyaGetBeanCallback<CameraPushDataBean> mqtt43Callback;
    public o0o00o0oo0 mqttPlugin = ((o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class));
    public o0o00o00o0 service = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));

    private o0oo00o00o getSandO(String str) {
        o0oo00o00o o0oo00o00o = SandRMap.getInstance().get(str);
        if (o0oo00o00o == null) {
            o0oo00o00o = new o0oo00o00o();
            SandRMap.getInstance().put(str, o0oo00o00o);
        }
        o0oo00o00o.O00000o0();
        return o0oo00o00o;
    }

    public void publish(String str, String str2, String str3, Object obj, int i) {
        o0oo00o00o sandO = getSandO(str);
        o0oo0oo0o0 O00000o0 = new o0oo0oo0o0().O000000o(obj).O00000o0(str3).O00000Oo(str2).O00000Oo(i).O000000o(str).O000000o(sandO.O00000Oo()).O00000o(sandO.O000000o()).O00000oO(sandO.O00000Oo()).O00000o0((int) TimeStampManager.instance().getCurrentTimeStamp());
        o0o00o0oo0 o0o00o0oo0 = this.mqttPlugin;
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O000000o(O00000o0, (IResultCallback) null);
        }
    }

    public void publishWirelessWake(String str, byte[] bArr) {
        o0o00o0oo0 o0o00o0oo0 = this.mqttPlugin;
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O000000o(str, bArr, (IResultCallback) new IResultCallback() {
                public void onError(String str, String str2) {
                }

                public void onSuccess() {
                    L.d(TuyaHomeCameraManager.TAG, "publish success");
                }
            });
        }
    }

    public void registerCamera308Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo0ooo.class, this.mq_308_receiver);
        }
        this.mqtt308Callback = iTuyaGetBeanCallback;
    }

    public void registerCameraP2P302Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo0oo0.class, this.mq_302_receiver);
        }
        this.mqtt302Callback = iTuyaGetBeanCallback;
    }

    public void registerCameraPushListener(ITuyaGetBeanCallback<CameraPushDataBean> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oooo0o.class, this.mq_43_receiver);
        }
        this.mqtt43Callback = iTuyaGetBeanCallback;
    }

    public void unRegisterCamera308Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo0ooo.class, this.mq_308_receiver);
        }
    }

    public void unRegisterCameraP2P302Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo0oo0.class, this.mq_302_receiver);
        }
    }

    public void unRegisterCameraPushListener(ITuyaGetBeanCallback<CameraPushDataBean> iTuyaGetBeanCallback) {
        o0o00o00o0 o0o00o00o0 = this.service;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oooo0o.class, this.mq_43_receiver);
        }
    }
}
