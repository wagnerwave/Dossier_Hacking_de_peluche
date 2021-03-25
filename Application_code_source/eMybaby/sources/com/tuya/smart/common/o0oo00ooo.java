package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.MD5Util;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.security.jni.JNICLibrary;

public class o0oo00ooo implements o0oo0oo00 {
    public static final String O000000o = "SdkMqttManager";

    public String O000000o() {
        User user;
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            return "";
        }
        return user.getPartnerIdentity() + "/mb/" + user.getUid();
    }

    public String O00000Oo() {
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null) {
            return "";
        }
        String str = TuyaSmartNetWork.mAppId;
        User user = o0o00oo0oo.O000000o().getUser();
        if (user == null) {
            return "";
        }
        String sid = user.getSid();
        String ecode = user.getEcode();
        String md5AsBase64 = MD5Util.md5AsBase64(MD5Util.md5AsBase64(str) + ecode);
        int length = md5AsBase64.length();
        return user.getPartnerIdentity() + "_" + str + "_mb_" + sid + md5AsBase64.substring(length - 16, length);
    }

    public String O00000o0() {
        User user;
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            return "";
        }
        String str = (String) JNICLibrary.doCommandNative(TuyaSmartSdk.getApplication(), 2, user.getEcode().getBytes(), (byte[]) null, TuyaSmartNetWork.mNTY, TuyaSmartNetWork.mD);
        if (str == null) {
            str = "value ==null";
        }
        int length = str.length() >> 1;
        return str.substring(length - 8, length + 8);
    }
}
