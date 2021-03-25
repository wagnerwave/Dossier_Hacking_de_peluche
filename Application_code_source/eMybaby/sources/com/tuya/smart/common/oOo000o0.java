package com.tuya.smart.common;

import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.TuyaConcurrentList;
import com.tuya.smart.android.device.utils.SandRMap;
import com.tuya.smart.android.mqtt.ITuyaMqttChannel;
import com.tuya.smart.android.mqtt.ITuyaMqttRetainChannelListener;
import com.tuya.smart.android.mqtt.MqttMessageBean;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.Map;

public class oOo000o0 implements ITuyaMqttChannel, o0OO00o0 {
    public static volatile oOo000o0 O00000Oo;
    public boolean O000000o;
    public TuyaConcurrentList<ITuyaMqttRetainChannelListener> O00000o0 = new TuyaConcurrentList<>();

    public static ITuyaMqttChannel O000000o() {
        if (O00000Oo == null) {
            synchronized (oOo000o0.class) {
                if (O00000Oo == null) {
                    O00000Oo = new oOo000o0();
                }
            }
        }
        return O00000Oo;
    }

    public static o0oo00o00o O000000o(String str) {
        o0oo00o00o o0oo00o00o = SandRMap.getInstance().get(str);
        if (o0oo00o00o == null) {
            o0oo00o00o = new o0oo00o00o();
            SandRMap.getInstance().put(str, o0oo00o00o);
        }
        o0oo00o00o.O00000o0();
        return o0oo00o00o;
    }

    public void onEventMainThread(final o0OO0OO0 o0oo0oo0) {
        this.O00000o0.query(new TuyaConcurrentList.QueryListCallback<ITuyaMqttRetainChannelListener>() {
            /* renamed from: O000000o */
            public void query(ITuyaMqttRetainChannelListener iTuyaMqttRetainChannelListener) {
                iTuyaMqttRetainChannelListener.onMessageReceived(new MqttMessageBean(o0oo0oo0.O000000o(), o0oo0oo0.O00000Oo(), o0oo0oo0.O00000o0()));
            }
        });
    }

    public void registerMqttRetainChannelListener(ITuyaMqttRetainChannelListener iTuyaMqttRetainChannelListener) {
        this.O00000o0.add(iTuyaMqttRetainChannelListener);
        if (!this.O000000o) {
            this.O000000o = true;
            TuyaSdk.getEventBus().register(this);
        }
    }

    public void sendDeviceMqttMessage(String str, HashMap<String, Object> hashMap, int i, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        oO00O00o.O000000o(str, dev.getPv(), dev.getLocalKey(), (Object) hashMap != null ? new JSONObject((Map<String, Object>) hashMap) : new JSONObject(), O000000o(str), i, iResultCallback);
    }

    public void unRegisterMqttRetainChannelListener(ITuyaMqttRetainChannelListener iTuyaMqttRetainChannelListener) {
        this.O00000o0.remove(iTuyaMqttRetainChannelListener);
        if (this.O000000o && this.O00000o0.getList().isEmpty()) {
            this.O000000o = false;
            TuyaSdk.getEventBus().unregister(this);
        }
    }
}
