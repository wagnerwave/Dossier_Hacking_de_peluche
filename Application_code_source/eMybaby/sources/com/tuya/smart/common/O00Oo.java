package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;

public class O00Oo extends O00Oo0o0 {
    public O0O0OO O0000o00 = new O0O0OO(((O00OoOO0) this.O00000oO).O0000O0o());

    public O00Oo(O00o00 o00o00) {
        super(o00o00);
    }

    public void O000000o() {
        super.O000000o();
        this.O0000o00.O000000o();
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
        this.O0000O0o.O000000o(((O00OoOO0) this.O00000oO).O00000oo());
        this.O0000O0o.O000000o(searchDeviceBean, this.O00000Oo.O00000o0(), this.O00000Oo.O00000o());
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, String str) {
        if (!TextUtils.equals(searchDeviceBean.getMacAdress(), this.O00000o.getMacAdress())) {
            StringBuilder n = a.n("doCustomCodeForFinale mac not equals currentConfigBean ");
            n.append(searchDeviceBean.getMacAdress());
            n.append(DpTimerBean.FILL);
            n.append(this.O00000o.getMacAdress());
            o00oo0oo00.O00000Oo("TuyaBlueMeshLocalActivator", n.toString());
            this.O00000oO.O000000o(searchDeviceBean, O00OOo.O0000OoO, "config mac not equal current mac ");
            return;
        }
        this.O00000oo.O000000o(searchDeviceBean, o000000o, str, new O0O000o() {
            public void O000000o() {
                O00Oo.this.O00000oO.O000000o(searchDeviceBean);
            }

            public void O000000o(String str, String str2) {
                O00Oo.this.O00000oO.O000000o(searchDeviceBean, str, str2);
            }
        });
    }

    public void O00000Oo(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
        if (!TextUtils.equals(searchDeviceBean.getMacAdress(), this.O00000o.getMacAdress())) {
            StringBuilder n = a.n("doCustomCodeForFinale mac not equals currentConfigBean ");
            n.append(searchDeviceBean.getMacAdress());
            n.append(DpTimerBean.FILL);
            n.append(this.O00000o.getMacAdress());
            o00oo0oo00.O00000Oo("TuyaBlueMeshLocalActivator", n.toString());
            this.O00000oO.O000000o(searchDeviceBean, O00OOo.O0000OoO, "config mac not equal current mac ");
            return;
        }
        this.O00000oo.O000000o(searchDeviceBean, o000000o, new ooooooo() {
            public void O000000o(String str) {
                O00Oo o00Oo = O00Oo.this;
                o00Oo.O0000o00.O000000o(searchDeviceBean, o00Oo.O00000Oo.O00000oO(), O00Oo.this.O00000Oo.O00000oo(), str);
            }

            public void O000000o(String str, String str2) {
                O00Oo.this.O00000oO.O000000o(searchDeviceBean, str, str2);
            }
        });
    }

    public void O0000OOo() {
        this.O00000oO = new O00OoOO0(this, this.O00000o0);
    }
}
