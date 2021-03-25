package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.common.OOO00O0;
import com.tuya.smart.home.sdk.api.config.IApConnectListener;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import java.util.Map;

public class OO0o implements IConfig {
    public static final String O000000o = "ApConfigUDP";
    public OO0Oo0 O00000Oo;
    public OO0Oo00 O00000o;
    public ActiveTokenBean O00000o0;
    public volatile boolean O00000oO = false;
    public IApConnectListener O00000oo;
    public OOO00Oo O0000O0o;
    public OOO0OO0 O0000OOo;

    public OO0o(OO0Oo00 oO0Oo00) {
        this.O00000o0 = new ActiveTokenBean(oO0Oo00.O0000Oo0());
        this.O00000o = oO0Oo00;
        this.O00000oo = oO0Oo00.O00000oO();
        OO0Oo0 oO0Oo0 = new OO0Oo0(this.O00000o);
        this.O00000Oo = oO0Oo0;
        oO0Oo0.O000000o(new OOO00O0.O000000o() {
            public void O000000o(String str) {
                if (OO0o.this.O00000oO && OO0o.this.O00000oo != null) {
                    OO0o.this.O00000oo.onDeviceConnect(str);
                }
            }
        });
    }

    public void O000000o(OOO00Oo oOO00Oo) {
        this.O0000O0o = oOO00Oo;
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000OOo = ooo0oo0;
    }

    public void cancel() {
        this.O00000oO = false;
    }

    public void onDestroy() {
        this.O00000oO = false;
        this.O00000Oo.onDestroy();
    }

    public void start() {
        OOO00Oo oOO00Oo = this.O0000O0o;
        if (oOO00Oo != null) {
            oOO00Oo.O00000oo().put("type", OO0OO0o.O00000o0.O00000Oo);
            this.O00000Oo.O000000o(this.O0000O0o);
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000Oo(a.r("type", OO0OO0o.O00000o0.O00000Oo), (Map<String, Object>) null);
            this.O00000Oo.O000000o(this.O0000OOo);
        }
        this.O00000oO = true;
        this.O00000Oo.O000000o(this.O00000o0);
        this.O00000Oo.O000000o();
    }
}
