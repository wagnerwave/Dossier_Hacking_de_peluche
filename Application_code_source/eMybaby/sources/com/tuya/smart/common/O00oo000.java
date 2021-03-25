package com.tuya.smart.common;

import a.e.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.tuya.sdk.bluemesh.local.login.ConnectAndLoginMesh$1;
import com.tuya.sdk.bluemesh.local.login.ConnectAndLoginMesh$2;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00o0oo00o;

public class O00oo000 {
    public static final String O0000OOo = "ConnectAndLoginMesh";
    public String O000000o;
    public String O00000Oo;
    public o00o0oo00o O00000o;
    public a O00000o0 = o00o0o0o00.O000000o().O00000Oo();
    public SearchDeviceBean O00000oO;
    public a.e.a.a.o.h.a O00000oo;
    public O00o O0000O0o;
    public Handler O0000Oo0;

    public O00oo000(O00o o00o) {
        this.O0000O0o = o00o;
        this.O0000Oo0 = new Handler(Looper.getMainLooper());
    }

    private void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.d(str);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final boolean z) {
        o00o0oo00o o00o0oo00o = new o00o0oo00o(o00ooo0000.O000000o(this.O000000o, 16), o00ooo0000.O000000o(this.O00000Oo, 16), new o00o0oo00o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(O00oo000.O0000OOo, "login onFailure code: " + str + " error: " + str2);
                if (!z) {
                    a O00000o = O00oo000.this.O00000o0;
                    O00000o.f3191a.f(O00oo000.this.O00000oO.getMacAdress());
                    O00oo000.this.O0000Oo0.postDelayed(new Runnable() {
                        public void run() {
                            O00oo000.this.O000000o(true);
                        }
                    }, 600);
                    return;
                }
                O00oo000.this.O0000O0o.O000000o(O00oo000.this.O00000oO, O00OOo.O00000Oo, str2);
            }

            public void O000000o(byte[] bArr) {
                o00oo0oo00.O000000o(O00oo000.O0000OOo, "login onSuccess");
                O00oo000.this.O00000oO.setSessionKey(bArr);
                O00oo000.this.O00000oO();
                O00oo000.this.O0000O0o.O000000o(O00oo000.this.O00000oO, O00OOo.O000000o);
                O00oo000.this.O0000O0o.O000000o(O00oo000.this.O00000oO, false);
            }
        });
        this.O00000o = o00o0oo00o;
        o00o0oo00o.O000000o(this.O00000oO.getMacAdress());
    }

    private void O00000o() {
        this.O00000oo = new ConnectAndLoginMesh$1(this);
        a aVar = this.O00000o0;
        aVar.f3191a.l(this.O00000oO.getMacAdress(), this.O00000oo);
        BleConnectOptions.b bVar = new BleConnectOptions.b();
        bVar.f4321a = 4;
        bVar.f4323c = PathInterpolatorCompat.MAX_NUM_POINTS;
        bVar.f4322b = 2;
        bVar.f4324d = RecyclerView.MAX_SCROLL_DURATION;
        this.O00000o0.o(this.O00000oO.getMacAdress(), new BleConnectOptions(bVar), new ConnectAndLoginMesh$2(this));
    }

    /* access modifiers changed from: private */
    public void O00000oO() {
        SearchDeviceBean searchDeviceBean = this.O00000oO;
        if (searchDeviceBean != null && this.O00000oo != null) {
            a aVar = this.O00000o0;
            aVar.f3191a.b(searchDeviceBean.getMacAdress(), this.O00000oo);
        }
    }

    public void O000000o() {
        if (this.O00000oO == null) {
            Log.e(O0000OOo, "searchDeviceBean is null");
            this.O0000O0o.O000000o((SearchDeviceBean) null, O00OOo.O0000Oo, "searchDeviceBean is null");
            return;
        }
        O00000o();
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
        this.O000000o = str;
        this.O00000Oo = str2;
        this.O00000oO = searchDeviceBean;
        if (searchDeviceBean == null) {
            Log.e(O0000OOo, "searchDeviceBean is null");
            this.O0000O0o.O000000o((SearchDeviceBean) null, O00OOo.O0000Oo, "searchDeviceBean is null");
            return;
        }
        O00000o();
    }

    public void O000000o(O00o o00o) {
        this.O0000O0o = o00o;
    }

    public void O00000Oo() {
        o00oo0oo00.O000000o(O0000OOo, "stopLogin");
        o00o0oo00o o00o0oo00o = this.O00000o;
        if (o00o0oo00o != null) {
            o00o0oo00o.O00000Oo();
            this.O00000o = null;
        }
        if (this.O00000oO != null) {
            StringBuilder n = a.a.a.a.a.n("stopLogin mac: ");
            n.append(this.O00000oO.getMacAdress());
            o00oo0oo00.O000000o(O0000OOo, n.toString());
            O00000oO();
            O000000o(this.O00000oO.getMacAdress());
        }
    }

    public void O00000o0() {
        o00oo0oo00.O000000o(O0000OOo, "onDestroy");
        O00000Oo();
    }
}
