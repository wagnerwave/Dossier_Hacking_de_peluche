package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;
import java.util.List;

public class O00Oo0o0 implements O00Oo0, O00Oo0OO {
    public static final String O000000o = "TuyaBlueMeshLocalActivator";
    public static final int O0000o00 = 136;
    public O00o00 O00000Oo;
    public SearchDeviceBean O00000o;
    public O00Oo00o O00000o0;
    public O00OoO0o O00000oO;
    public O0O00o0 O00000oo;
    public O00oo000 O0000O0o;
    public O00o000 O0000OOo;
    public O0O0OO0 O0000Oo;
    public O0O0O O0000Oo0;
    public boolean O0000OoO;
    public Handler.Callback O0000Ooo = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 136) {
                return false;
            }
            StringBuilder n = a.n("WHAT_TIME_OUT ");
            n.append(O00Oo0o0.this.O0000o0);
            o00oo0oo00.O000000o("TuyaBlueMeshLocalActivator", n.toString());
            O00Oo00o o00Oo00o = O00Oo0o0.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o((SearchDeviceBean) null, O00OOo.O0000Ooo, "time out");
                O00Oo0o0.this.O00000o0.O000000o();
            }
            O00Oo0o0.this.O000000o();
            return false;
        }
    };
    public int O0000o0;
    public List<SearchDeviceBean> O0000o0O;
    public Handler O0000o0o = new Handler(Looper.getMainLooper(), this.O0000Ooo);

    public O00Oo0o0(O00o00 o00o00) {
        this.O00000Oo = o00o00;
        this.O0000o0O = o00o00.O0000O0o();
        this.O00000o0 = o00o00.O0000OOo();
        O0000OOo();
        this.O0000o0 = o00o00.O0000Oo0();
        this.O0000O0o = new O00oo000(this.O00000oO.O000000o());
        this.O0000OOo = new O00o000(this.O00000oO.O00000Oo());
        this.O0000Oo0 = new O0O0O(this.O00000oO.O00000o0());
        this.O0000Oo = new O0O0OO0(this.O00000oO.O00000o());
    }

    public void O000000o() {
        this.O0000OoO = true;
        this.O0000O0o.O00000o0();
        this.O0000OOo.O00000o0();
        this.O0000Oo0.O000000o();
        this.O00000o0 = null;
        this.O00000oO.O00000oO();
        this.O0000o0o.removeMessages(136);
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O0000O0o.O000000o(this.O00000oO.O000000o());
        this.O0000O0o.O000000o(searchDeviceBean, this.O00000Oo.O000000o(), this.O00000Oo.O00000Oo());
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
        if (!TextUtils.equals(searchDeviceBean.getMacAdress(), this.O00000o.getMacAdress())) {
            StringBuilder n = a.n("doCustomCodeForFinale mac not equals currentConfigBean ");
            n.append(searchDeviceBean.getMacAdress());
            n.append(DpTimerBean.FILL);
            n.append(this.O00000o.getMacAdress());
            o00oo0oo00.O00000Oo("TuyaBlueMeshLocalActivator", n.toString());
            this.O00000oO.O000000o(searchDeviceBean, O00OOo.O0000OoO, "config mac not equal current mac ");
            return;
        }
        this.O00000oo.O000000o(searchDeviceBean, o000000o, "", new O0O000o() {
            public void O000000o() {
                O00Oo0o0.this.O00000oO.O000000o(searchDeviceBean);
            }

            public void O000000o(String str, String str2) {
                O00Oo0o0.this.O00000oO.O000000o(searchDeviceBean, str, str2);
            }
        });
    }

    public void O000000o(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o, String str) {
    }

    public void O000000o(O0O00o0 o0O00o0) {
        this.O00000oo = o0O00o0;
        O0000Oo0();
        O0000O0o();
    }

    public void O00000Oo() {
        this.O0000O0o.O00000Oo();
    }

    public void O00000Oo(SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
    }

    public void O00000o() {
        this.O0000OOo.O000000o();
    }

    public void O00000o0() {
        this.O0000OOo.O000000o(this.O00000o);
    }

    public void O00000oO() {
        this.O00000oo.O000000o(this.O00000o, new O0O00oO() {
            public void O000000o(int i) {
                O00Oo0o0 o00Oo0o0 = O00Oo0o0.this;
                o00Oo0o0.O0000Oo0.O000000o(o00Oo0o0.O00000o, i);
            }

            public void O000000o(String str, String str2) {
                O00Oo0o0 o00Oo0o0 = O00Oo0o0.this;
                o00Oo0o0.O00000oO.O000000o(o00Oo0o0.O00000o, str, str2);
            }
        });
    }

    public void O00000oo() {
        this.O0000Oo.O000000o(this.O00000o, this.O00000Oo.O00000o0(), this.O00000Oo.O00000o());
    }

    public void O0000O0o() {
        if (!this.O0000OoO) {
            if (this.O0000o0O.isEmpty()) {
                O00Oo00o o00Oo00o = this.O00000o0;
                if (o00Oo00o != null) {
                    o00Oo00o.O000000o();
                }
                O000000o();
                return;
            }
            SearchDeviceBean remove = this.O0000o0O.remove(0);
            this.O00000o = remove;
            O000000o(remove);
        }
    }

    public void O0000OOo() {
        this.O00000oO = new O00OoO0o(this, this.O00000o0);
    }

    public void O0000Oo0() {
        this.O0000o0o.removeMessages(136);
        this.O0000o0o.sendEmptyMessageDelayed(136, (long) (this.O0000o0 * 1000));
    }
}
