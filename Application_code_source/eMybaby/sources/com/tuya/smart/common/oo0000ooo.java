package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;

public class oo0000ooo extends oo0000o0o {
    public static final String O00000Oo = "MsgProtocol2_1";
    public o0ooooo00 O00000o0;

    public oo0000ooo(o0oooo0oo o0oooo0oo) {
        super(o0oooo0oo);
    }

    private void O000000o(String str, JSONObject jSONObject) {
        Integer integer = jSONObject.getInteger(o0ooo00oo.O00000o);
        if (integer == null) {
            O000000o("12004", "protocol is not exist");
        } else {
            this.O00000o0.O000000o(integer.intValue(), jSONObject);
        }
    }

    private void O000000o(String str, String str2) {
        L.d(O00000Oo, "error: " + str + " errorMsg: " + str2);
        o0ooooo00 o0ooooo00 = this.O00000o0;
        if (o0ooooo00 != null) {
            o0ooooo00.O000000o(str, str2);
        }
    }

    private void O000000o(String str, String str2, String str3, String str4) {
        String substring = str3.substring(0, 16);
        String substring2 = str3.substring(16);
        if (substring.equals(o0ooo00oo.O000000o(str, substring2, str2))) {
            String O00000Oo2 = o0ooo0o00.O00000Oo(substring2, str2);
            if (TextUtils.isEmpty(O00000Oo2)) {
                O000000o("12001", "dealWithDeviceTopic2_1 data parsing failure");
            } else {
                O000000o(str4, JSON.parseObject(O00000Oo2));
            }
        } else {
            O000000o("12002", "signature is not match 2_1");
        }
    }

    public void O000000o(o0ooooo00 o0ooooo00) {
        this.O00000o0 = o0ooooo00;
        O000000o(this.O000000o.O00000o0(), this.O000000o.O000000o, new String(this.O000000o.O00000Oo()).substring(3), this.O000000o.O000000o());
    }
}
