package com.tuya.smart.common;

import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IGroupListener;

public class oO00o000 implements o0O0Oo00, o0o0o00000 {
    public static final String O000000o = "TuyaGroupMonitorManager";
    public final IGroupListener O00000Oo;
    public final long O00000o0;

    public oO00o000(long j, IGroupListener iGroupListener) {
        if (iGroupListener != null) {
            this.O00000o0 = j;
            oOo0oooO.O000000o().registerDeviceMqttListener(o0o0ooo0o0.class, this);
            oOo0oooO.O000000o().registerDeviceMqttListener(o0o0ooooo0.class, this);
            this.O00000Oo = iGroupListener;
            TuyaSdk.getEventBus().register(this);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void O000000o(o0o0ooo0o0 o0o0ooo0o0) {
        if (o0o0ooo0o0.O00000o0() == 0) {
            if (this.O00000Oo != null && o0o0ooo0o0.O000000o() == this.O00000o0) {
                this.O00000Oo.onGroupRemoved(o0o0ooo0o0.O000000o());
            }
        } else if (o0o0ooo0o0.O00000o0() == 2 && this.O00000Oo != null) {
            long O000000o2 = o0o0ooo0o0.O000000o();
            long j = this.O00000o0;
            if (O000000o2 == j) {
                this.O00000Oo.onGroupInfoUpdate(j);
            }
        }
    }

    private void O000000o(o0o0ooooo0 o0o0ooooo0) {
        if (this.O00000Oo != null && o0o0ooooo0.O00000o0() == this.O00000o0) {
            this.O00000Oo.onDpUpdate(o0o0ooooo0.O00000o0(), o0o0ooooo0.O000000o());
        }
    }

    public void O000000o() {
        TuyaSdk.getEventBus().unregister(this);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0ooo0o0.class, this);
        oOo0oooO.O000000o().unRegisterDeviceMqttListener(o0o0ooooo0.class, this);
    }

    public void onEventMainThread(o0O0o000 o0o0o000) {
        if (o0o0o000 != null) {
            long O00000Oo2 = o0o0o000.O00000Oo();
            IGroupListener iGroupListener = this.O00000Oo;
            if (iGroupListener != null && O00000Oo2 == this.O00000o0) {
                iGroupListener.onDpUpdate(O00000Oo2, o0o0o000.O000000o());
            }
        }
    }

    public void onResult(Object obj) {
        if (obj instanceof o0o0ooo0o0) {
            O000000o((o0o0ooo0o0) obj);
        } else if (obj instanceof o0o0ooooo0) {
            O000000o((o0o0ooooo0) obj);
        }
    }
}
