package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.inuker.bluetooth.library.model.BleGattService;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O00OoO0o {
    public static final String O000000o = "TuyaLocalActivatorImpl";
    public O00Oo0OO O00000Oo;
    public Handler O00000o;
    public O00Oo00o O00000o0;
    public Map<String, O00Ooo00.O000000o> O00000oO = new HashMap();
    public O00o O00000oo = new O00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            O00Oo00o o00Oo00o = O00OoO0o.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, str);
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoO0o.this.O000000o(searchDeviceBean, str, str2);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, boolean z) {
            O00OoO0o.this.O00000Oo.O00000o0();
        }

        public void O000000o(List<BleGattService> list) {
        }
    };
    public O00o0000 O0000O0o = new O00o0000() {
        public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
            StringBuilder n = a.n("getAuthkey success ");
            n.append(o000000o.O000000o());
            n.append("   ");
            n.append(o000000o.O00000o0());
            Log.d(O00OoO0o.O000000o, n.toString());
            O00Oo00o o00Oo00o = O00OoO0o.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O00000o0);
            }
            O00OoO0o.this.O00000oO.put(searchDeviceBean.getMacAdress(), o000000o);
            O00OoO0o.this.O00000Oo.O00000o();
            O00OoO0o.this.O00000Oo.O00000oO();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoO0o.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public O0O00o O0000OOo = new O0O00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            O00Oo00o o00Oo00o = O00OoO0o.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O00000oO);
            }
            O00OoO0o.this.O00000Oo.O00000oo();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoO0o.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public O0O0O0o O0000Oo0 = new O0O0O0o() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            O00Oo00o o00Oo00o = O00OoO0o.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O0000O0o);
            }
            if (O00OoO0o.this.O00000oO.get(searchDeviceBean.getMacAdress()) == null) {
                O00OoO0o o00OoO0o = O00OoO0o.this;
                o00OoO0o.O000000o(searchDeviceBean, O00OOo.O0000OoO, searchDeviceBean.getMacAdress() + "  authKeyUUIDBean is null");
                return;
            }
            O00OoO0o.this.O00000Oo.O00000Oo();
            O00OoO0o o00OoO0o2 = O00OoO0o.this;
            o00OoO0o2.O00000Oo.O000000o(searchDeviceBean, o00OoO0o2.O00000oO.get(searchDeviceBean.getMacAdress()));
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoO0o.this.O000000o(searchDeviceBean, str, str2);
        }
    };

    public O00OoO0o(O00Oo0OO o00Oo0OO, O00Oo00o o00Oo00o) {
        this.O00000Oo = o00Oo0OO;
        this.O00000o0 = o00Oo00o;
        this.O00000o = new Handler(Looper.getMainLooper());
    }

    public O00o O000000o() {
        return this.O00000oo;
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O00000Oo.O00000Oo();
        this.O00000Oo.O00000o();
        O00Oo00o o00Oo00o = this.O00000o0;
        if (o00Oo00o != null) {
            o00Oo00o.O000000o(searchDeviceBean);
        }
        this.O00000o.postDelayed(new Runnable() {
            public void run() {
                O00OoO0o.this.O00000Oo.O0000O0o();
            }
        }, 500);
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
        this.O00000Oo.O00000Oo();
        this.O00000Oo.O00000o();
        O00Oo00o o00Oo00o = this.O00000o0;
        if (o00Oo00o != null) {
            o00Oo00o.O000000o(searchDeviceBean, str, str2);
        }
        this.O00000o.postDelayed(new Runnable() {
            public void run() {
                O00OoO0o.this.O00000Oo.O0000O0o();
            }
        }, 300);
    }

    public O00o0000 O00000Oo() {
        return this.O0000O0o;
    }

    public O0O0O0o O00000o() {
        return this.O0000Oo0;
    }

    public O0O00o O00000o0() {
        return this.O0000OOo;
    }

    public void O00000oO() {
        this.O00000o0 = null;
        this.O00000oO.clear();
    }
}
