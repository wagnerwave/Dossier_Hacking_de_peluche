package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.tuya.sdk.config.enums.GwModeEnum;
import com.tuya.smart.android.common.utils.LogUtils;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.interior.enums.ActiveEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OOO extends OOO00O0 implements o0o0o0o0o0, o0oo00oo00 {
    public String O00000oO;
    public volatile boolean O00000oo;
    public List<String> O0000O0o;
    public o0o00o00o0 O0000OOo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class));
    public OOO00Oo O0000Oo;
    public o0o00o0o00 O0000Oo0 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));
    public o0oo0o0ooo O0000OoO = ((o0oo0o0ooo) Oo0.O000000o(o0oo0o0ooo.class));
    public OOO0OO0 O0000Ooo;

    public OOO(Context context, String str) {
        super(context);
        this.O00000oO = str;
        O00000o();
        this.O0000Oo = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
    }

    private void O00000o() {
        OOOo00.O000000o();
    }

    public void O000000o() {
        if (!this.O00000oo) {
            this.O00000oo = true;
            this.O0000O0o = new ArrayList();
            o0o00o0o00 o0o00o0o00 = this.O0000Oo0;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O000000o().O000000o((o0oo00oo00) this);
            }
            o0o00o00o0 o0o00o00o0 = this.O0000OOo;
            if (o0o00o00o0 != null) {
                o0o00o00o0.O0000o00().registerTuyaHardwareOnlineStatusListener(this);
            }
        }
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
        if (this.O00000oo && this.O0000O0o.contains(hgwBean.gwId)) {
            LogUtils.logServer(OOOOO00.O000000o, OOOOO00.O000000o(OOOOO00.O0000OoO, this.O00000oO));
            if (this.O00000o != null && TextUtils.isEmpty(hgwBean.getVersion())) {
                this.O00000o.O000000o(hgwBean.getGwId());
            }
        }
    }

    public void O000000o(OOO0OO0 ooo0oo0) {
        this.O0000Ooo = ooo0oo0;
    }

    public void O000000o(List<HgwBean> list) {
        if (this.O00000oo) {
            for (HgwBean next : list) {
                if (next.getActive() == ActiveEnum.UNACTIVE.getType() && next.getMode() == GwModeEnum.EC.getType()) {
                    o0o00o0o00 o0o00o0o00 = this.O0000Oo0;
                    if (o0o00o0o00 != null) {
                        o0o00o0o00.O000000o().O000000o(next);
                    }
                    this.O0000O0o.add(next.getGwId());
                    OOO00Oo oOO00Oo = this.O0000Oo;
                    if (oOO00Oo != null) {
                        oOO00Oo.O000000o(System.currentTimeMillis());
                        this.O0000Oo.O00000oo().put("type", OO0OO0o.O00000o0.O00000o0);
                        o0oo0o0ooo o0oo0o0ooo = this.O0000OoO;
                        if (o0oo0o0ooo != null) {
                            o0oo0o0ooo.O000000o("bc78b0af622a504d8d1d7dc12bf84f0c", this.O0000Oo.O00000oo());
                        }
                    }
                    if (this.O0000Ooo != null) {
                        this.O0000Ooo.O00000Oo(a.r("type", OO0OO0o.O00000o0.O00000o0), (Map<String, Object>) null);
                    }
                }
            }
        }
    }

    public void O00000Oo() {
        if (this.O00000oo) {
            this.O00000oo = false;
            this.O0000O0o.clear();
        }
    }

    public OOO00Oo O00000o0() {
        return this.O0000Oo;
    }

    public void onDestroy() {
        O00000Oo();
        o0o00o00o0 o0o00o00o0 = this.O0000OOo;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterTuyaHardwareOnlineStatusListener(this);
        }
        o0o00o0o00 o0o00o0o00 = this.O0000Oo0;
        if (o0o00o0o00 != null) {
            o0o00o0o00.O000000o().O00000Oo((o0oo00oo00) this);
        }
        super.onDestroy();
    }
}
