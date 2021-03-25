package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.api.ISubDevListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class oOo00o00 implements NetWorkStatusEvent, oO0Oo0O0, ISubDevListener {
    public static final String O000000o = "TuyaSubDeviceMonitorProxy";
    public final String O00000Oo;
    public IDevListener O00000o;
    public final oO00Oo00 O00000o0;
    public final String O00000oO;

    public oOo00o00(String str, String str2, String str3, IDevListener iDevListener) {
        this.O00000oO = str2;
        this.O00000Oo = str3;
        this.O00000o = iDevListener;
        oO00Oo00 oo00oo00 = new oO00Oo00(str);
        this.O00000o0 = oo00oo00;
        oo00oo00.registerSubDevListener(this);
        L.d(O000000o, "meshId: " + str + " devId: " + str2 + " nodeId: " + str3);
        TuyaSdk.getEventBus().register(this);
    }

    private int O000000o(List<String> list, List<String> list2) {
        if (list != null) {
            for (String equals : list) {
                if (TextUtils.equals(equals, this.O00000Oo)) {
                    return 1;
                }
            }
        }
        if (list2 == null) {
            return 0;
        }
        for (String equals2 : list2) {
            if (TextUtils.equals(equals2, this.O00000Oo)) {
                return -1;
            }
        }
        return 0;
    }

    private void O000000o(boolean z) {
        IDevListener iDevListener;
        boolean z2;
        String str;
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000oO);
        if ((dev == null || !dev.getIsLocalOnline().booleanValue()) && !z) {
            iDevListener = this.O00000o;
            if (iDevListener != null) {
                str = this.O00000oO;
                z2 = false;
            } else {
                return;
            }
        } else {
            iDevListener = this.O00000o;
            if (iDevListener != null) {
                str = this.O00000oO;
                z2 = true;
            } else {
                return;
            }
        }
        iDevListener.onNetworkStatusChanged(str, z2);
    }

    public void O000000o() {
        this.O00000o0.onDestroy();
        this.O00000o = null;
        TuyaSdk.getEventBus().unregister(this);
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        O000000o(netWorkStatusEventModel.isAvailable());
    }

    public void onSubDevAdded(String str) {
    }

    public void onSubDevDpUpdate(String str, String str2) {
        IDevListener iDevListener;
        if (TextUtils.equals(this.O00000Oo, str) && (iDevListener = this.O00000o) != null) {
            iDevListener.onDpUpdate(this.O00000oO, str2);
        }
    }

    public void onSubDevInfoUpdate(String str) {
        a.v("devid=", str, O000000o);
        if (TextUtils.equals(this.O00000oO, str) && this.O00000o != null) {
            L.d(O000000o, "onDevInfoUpdate");
            this.O00000o.onDevInfoUpdate(this.O00000oO);
        }
    }

    public void onSubDevRemoved(String str) {
        IDevListener iDevListener;
        if (TextUtils.equals(this.O00000oO, str) && (iDevListener = this.O00000o) != null) {
            iDevListener.onRemoved(this.O00000oO);
        }
    }

    public void onSubDevStatusChanged(List<String> list, List<String> list2) {
        int O000000o2 = O000000o(list, list2);
        if (O000000o2 == 0) {
            L.d(O000000o, "status: 0");
            return;
        }
        StringBuilder n = a.n("onSubDevStatusChanged devId: ");
        n.append(this.O00000oO);
        n.append("status: ");
        boolean z = true;
        if (O000000o2 != 1) {
            z = false;
        }
        n.append(z);
        L.d(O000000o, n.toString());
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000oO);
        IDevListener iDevListener = this.O00000o;
        if (iDevListener != null && dev != null) {
            iDevListener.onStatusChanged(this.O00000oO, dev.getIsOnline().booleanValue());
        }
    }
}
