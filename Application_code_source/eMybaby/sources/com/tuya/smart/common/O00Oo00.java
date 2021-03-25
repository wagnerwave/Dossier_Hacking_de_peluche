package com.tuya.smart.common;

import android.app.Application;
import com.tuya.spongycastle.jce.provider.BouncyCastleProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Security;

public class O00Oo00 {
    public static Application O000000o;

    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    public static synchronized Application O000000o() {
        Application application;
        synchronized (O00Oo00.class) {
            if (O000000o == null) {
                O000000o = O00000Oo();
            }
            application = O000000o;
        }
        return application;
    }

    public static O00Oo0 O000000o(O00o00 o00o00) {
        return new O00Oo0o0(o00o00);
    }

    public static O00Oo0 O000000o(oooo00o00 oooo00o00) {
        return new oooo000o0(oooo00o00);
    }

    public static void O000000o(Application application, boolean z) {
        O000000o = application;
        o00oo0oo00.O000000o(z);
    }

    public static Application O00000Oo() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke((Object) null, new Object[0]));
        } catch (Exception unused) {
            return O000000o;
        }
    }

    public static O00Oo0 O00000Oo(O00o00 o00o00) {
        return new O00Oo(o00o00);
    }
}
