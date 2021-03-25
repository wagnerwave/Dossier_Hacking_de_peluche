package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.security.jni.JNICLibrary;

public class oo00o000o {
    public static volatile oo00o000o O00000Oo;
    public final Context O000000o;

    public oo00o000o(Context context) {
        this.O000000o = context;
    }

    public static oo00o000o O000000o() {
        if (O00000Oo == null) {
            synchronized (oo00o000o.class) {
                if (O00000Oo == null) {
                    O00000Oo = new oo00o000o(TuyaSmartNetWork.getAppContext());
                }
            }
        }
        return O00000Oo;
    }

    public String O000000o(String str) {
        String str2 = (String) JNICLibrary.doCommandNative(this.O000000o, 1, str.getBytes(), (byte[]) null, TuyaSmartNetWork.mNTY, TuyaSmartNetWork.mD);
        return str2 == null ? "value == null" : str2;
    }
}
