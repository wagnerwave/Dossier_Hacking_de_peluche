package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.interior.event.DevUpdateEvent;
import com.tuya.smart.interior.event.DevUpdateEventModel;
import com.tuya.smart.interior.event.DeviceUpdateEvent;
import com.tuya.smart.interior.event.DeviceUpdateEventModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.bean.DeviceBean;

public class oO00OO0O implements NetWorkStatusEvent, o0O0O0Oo, o0OO000o, o0o0o00000, oO0Oo0O0, DevUpdateEvent, DeviceUpdateEvent {
    public static final String O000000o = "TuyaDeviceMonitorManager";
    public IDevListener O00000Oo;
    public final String O00000o0;

    public oO00OO0O(String str, IDevListener iDevListener) {
        if (iDevListener != null) {
            this.O00000o0 = str;
            TuyaSdk.getEventBus().register(this);
            oOo0oooO.O000000o().registerDeviceMqttListener(o0o0oooooo.class, this);
            this.O00000Oo = iDevListener;
            O000000o(NetworkUtil.isNetworkAvailable(TuyaSdk.getApplication()), O00000o0());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void O000000o(o0o0oooooo o0o0oooooo) {
        if (TextUtils.equals(o0o0oooooo.O000000o(), this.O00000o0) && this.O00000Oo != null && !TextUtils.isEmpty(o0o0oooooo.O00000o())) {
            this.O00000Oo.onDpUpdate(o0o0oooooo.O00000oO(), o0o0oooooo.O00000o());
        }
    }

    private void O000000o(boolean z, boolean z2) {
        String str;
        IDevListener iDevListener;
        boolean z3;
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        if ((dev == null || !dev.getIsLocalOnline().booleanValue()) && (!z || !z2)) {
            iDevListener = this.O00000Oo;
            if (iDevListener != null) {
                str = this.O00000o0;
                z3 = false;
            } else {
                return;
            }
        } else {
            iDevListener = this.O00000Oo;
            if (iDevListener != null) {
                str = this.O00000o0;
                z3 = true;
            } else {
                return;
            }
        }
        iDevListener.onNetworkStatusChanged(str, z3);
    }

    private void O00000Oo() {
        IDevListener iDevListener;
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        if (dev != null && (iDevListener = this.O00000Oo) != null) {
            iDevListener.onDpUpdate(this.O00000o0, JSON.toJSONString(dev.getDps()));
        }
    }

    private boolean O00000o0() {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        return dev != null && dev.isWifiDevice();
    }

    public void O000000o() {
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0ooo00o.class, this);
        TuyaSdk.getEventBus().unregister(this);
        this.O00000Oo = null;
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        O000000o(netWorkStatusEventModel.isAvailable(), O00000o0());
    }

    public void onEventMainThread(o0O0O0o0 o0o0o0o0) {
        IDevListener iDevListener;
        if (TextUtils.equals(this.O00000o0, o0o0o0o0.O000000o()) && !TextUtils.isEmpty(o0o0o0o0.O00000Oo()) && (iDevListener = this.O00000Oo) != null) {
            iDevListener.onDpUpdate(this.O00000o0, o0o0o0o0.O00000Oo());
        }
    }

    public void onEventMainThread(o0OO00OO o0oo00oo) {
        HgwBean O000000o2 = o0oo00oo.O000000o();
        if (O000000o2 != null && TextUtils.equals(O000000o2.getGwId(), this.O00000o0)) {
            O000000o(NetworkUtil.isNetworkAvailable(TuyaSdk.getApplication()), O00000o0());
            IDevListener iDevListener = this.O00000Oo;
            if (iDevListener != null) {
                iDevListener.onDevInfoUpdate(O000000o2.getGwId());
            }
        }
    }

    public void onEventMainThread(DevUpdateEventModel devUpdateEventModel) {
        if (TextUtils.equals(this.O00000o0, devUpdateEventModel.getDevId())) {
            DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
            if (dev == null) {
                IDevListener iDevListener = this.O00000Oo;
                if (iDevListener != null) {
                    iDevListener.onRemoved(this.O00000o0);
                    this.O00000Oo = null;
                    return;
                }
                return;
            }
            StringBuilder n = a.n("devId: ");
            n.append(this.O00000o0);
            n.append(" online:");
            n.append(dev.getIsOnline());
            L.d(O000000o, n.toString());
            IDevListener iDevListener2 = this.O00000Oo;
            if (iDevListener2 != null) {
                iDevListener2.onStatusChanged(this.O00000o0, dev.getIsOnline().booleanValue());
                if (dev.getIsOnline().booleanValue()) {
                    O00000Oo();
                }
            }
        }
    }

    public void onEventMainThread(DeviceUpdateEventModel deviceUpdateEventModel) {
        if (TextUtils.equals(deviceUpdateEventModel.getDevId(), this.O00000o0) && this.O00000Oo != null) {
            if (deviceUpdateEventModel.getMode() == 1) {
                this.O00000Oo.onRemoved(this.O00000o0);
            } else if (deviceUpdateEventModel.getMode() == 2) {
                this.O00000Oo.onDevInfoUpdate(this.O00000o0);
            }
        }
    }

    public void onResult(Object obj) {
        if (obj instanceof o0o0oooooo) {
            O000000o((o0o0oooooo) obj);
        }
    }
}
