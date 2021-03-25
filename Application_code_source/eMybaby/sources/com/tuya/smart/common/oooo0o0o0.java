package com.tuya.smart.common;

import a.e.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.tuya.sdk.sigmesh.connect.ConnectSigMesh$1;
import com.tuya.sdk.sigmesh.connect.ConnectSigMesh$4;
import com.tuya.sdk.sigmesh.connect.ConnectSigMesh$5;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class oooo0o0o0 {
    public static final String O0000O0o = "ConnectSigMesh";
    public a O000000o = o00o0o0o00.O000000o().O00000Oo();
    public o00o0oo00o O00000Oo;
    public a.e.a.a.o.h.a O00000o;
    public SearchDeviceBean O00000o0;
    public O00o O00000oO;
    public boolean O00000oo;
    public Handler O0000OOo;
    public boolean O0000Oo0 = false;

    public oooo0o0o0(O00o o00o) {
        this.O00000oO = o00o;
        this.O0000OOo = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void O00000oO() {
        this.O0000Oo0 = false;
        this.O00000o = new ConnectSigMesh$4(this);
        boolean z = this.O00000oo;
        a aVar = this.O000000o;
        aVar.f3191a.l(this.O00000o0.getMacAdress(), this.O00000o);
        BleConnectOptions.b bVar = new BleConnectOptions.b();
        bVar.f4321a = 4;
        bVar.f4323c = 6000;
        bVar.f4322b = 2;
        bVar.f4324d = 5000;
        this.O000000o.o(this.O00000o0.getMacAdress(), new BleConnectOptions(bVar), new ConnectSigMesh$5(this));
    }

    /* access modifiers changed from: private */
    public void O00000oo() {
        SearchDeviceBean searchDeviceBean = this.O00000o0;
        if (searchDeviceBean != null && this.O00000o != null) {
            a aVar = this.O000000o;
            aVar.f3191a.b(searchDeviceBean.getMacAdress(), this.O00000o);
        }
    }

    public void O000000o() {
        if (this.O00000o0 != null) {
            o00oo0oo00.O00000Oo(O0000O0o, "doRefreshCache");
            a aVar = this.O000000o;
            aVar.f3191a.f(this.O00000o0.getMacAdress());
        }
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O00000o0 = searchDeviceBean;
        this.O00000oo = false;
        if (searchDeviceBean == null) {
            o00oo0oo00.O00000Oo(O0000O0o, "searchDeviceBean is null");
            this.O00000oO.O000000o((SearchDeviceBean) null, O00OOo.O0000Oo, "searchDeviceBean is null");
            return;
        }
        O00000oO();
    }

    public void O000000o(O00o o00o) {
        this.O00000oO = o00o;
    }

    public void O00000Oo() {
        if (this.O00000o0 == null) {
            o00oo0oo00.O00000Oo(O0000O0o, "searchDeviceBean is null");
            this.O00000oO.O000000o((SearchDeviceBean) null, O00OOo.O0000Oo, "searchDeviceBean is null");
            return;
        }
        this.O00000oo = true;
        this.O0000Oo0 = false;
        O00000oo();
        a aVar = this.O000000o;
        aVar.f3191a.f(this.O00000o0.getMacAdress());
        this.O0000OOo.postDelayed(new Runnable() {
            public void run() {
                oooo0o0o0.this.O000000o.d(oooo0o0o0.this.O00000o0.getMacAdress());
            }
        }, 2000);
        this.O0000OOo.postDelayed(new Runnable() {
            public void run() {
                oooo0o0o0.this.O00000oO();
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    public void O00000o() {
        o00oo0oo00.O000000o(O0000O0o, "onDestroy");
        O00000o0();
    }

    public void O00000o0() {
        o00oo0oo00.O000000o(O0000O0o, "stopLogin");
        this.O0000Oo0 = false;
        o00o0oo00o o00o0oo00o = this.O00000Oo;
        if (o00o0oo00o != null) {
            o00o0oo00o.O00000Oo();
            this.O00000Oo = null;
        }
        if (this.O00000o0 != null) {
            StringBuilder n = a.a.a.a.a.n("stopLogin mac: ");
            n.append(this.O00000o0.getMacAdress());
            o00oo0oo00.O000000o(O0000O0o, n.toString());
            O00000oo();
            O000000o(this.O00000o0.getMacAdress());
        }
    }

    public void O000000o(o00o0o0o0o.O000000o o000000o) {
        if (this.O00000o0 != null) {
            o00oo0oo00.O00000Oo(O0000O0o, "doDiscoveryServices");
            a aVar = this.O000000o;
            aVar.f3191a.g(this.O00000o0.getMacAdress(), new ConnectSigMesh$1(this, o000000o));
        }
    }

    private void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O000000o.d(str);
            this.O000000o.f3191a.f(str);
        }
    }
}
