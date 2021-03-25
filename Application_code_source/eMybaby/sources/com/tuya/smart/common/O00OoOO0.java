package com.tuya.smart.common;

import android.text.TextUtils;
import com.inuker.bluetooth.library.model.BleGattService;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;
import java.util.List;

public class O00OoOO0 extends O00OoO0o {
    public O00o O0000Oo = new O00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            if (O00OoOO0.this.O00000o0 != null) {
                if (TextUtils.equals(O00OOo.O000000o, str)) {
                    str = O00OOo.O0000o0O;
                } else if (TextUtils.equals(O00OOo.O0000Oo0, str)) {
                    str = O00OOo.O0000o00;
                }
                O00OoOO0.this.O00000o0.O000000o(searchDeviceBean, str);
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoOO0.this.O000000o(searchDeviceBean, str, str2);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, boolean z) {
            O00Ooo00.O000000o o000000o = O00OoOO0.this.O00000oO.get(searchDeviceBean.getMacAdress());
            if (o000000o == null) {
                O00OoOO0 o00OoOO0 = O00OoOO0.this;
                o00OoOO0.O000000o(searchDeviceBean, O00OOo.O0000OoO, searchDeviceBean.getMacAdress() + "  authKeyUUIDBean is null");
                return;
            }
            O00OoOO0.this.O00000Oo.O00000Oo(searchDeviceBean, o000000o);
        }

        public void O000000o(List<BleGattService> list) {
        }
    };
    public O0O0OOO O0000OoO = new O0O0OOO() {
        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            O00Oo00o o00Oo00o = O00OoOO0.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O0000o);
            }
            O00OoOO0.this.O00000Oo.O00000Oo();
            O00Ooo00.O000000o o000000o = O00OoOO0.this.O00000oO.get(searchDeviceBean.getMacAdress());
            if (o000000o == null) {
                O00OoOO0 o00OoOO0 = O00OoOO0.this;
                o00OoOO0.O000000o(searchDeviceBean, O00OOo.O0000OoO, searchDeviceBean.getMacAdress() + "  authKeyUUIDBean is null");
                return;
            }
            O00OoOO0.this.O00000Oo.O000000o(searchDeviceBean, o000000o, str);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            O00OoOO0.this.O000000o(searchDeviceBean, str, str2);
        }
    };

    public O00OoOO0(O00Oo0OO o00Oo0OO, O00Oo00o o00Oo00o) {
        super(o00Oo0OO, o00Oo00o);
    }

    public O00o O00000oo() {
        return this.O0000Oo;
    }

    public O0O0OOO O0000O0o() {
        return this.O0000OoO;
    }
}
