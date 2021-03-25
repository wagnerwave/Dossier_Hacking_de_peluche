package com.tuya.smart.security.jni;

import android.content.Context;

public class JNICLibrary {
    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("jnimain");
    }

    public static native Object doCommandNative(Context context, int i, byte[] bArr, byte[] bArr2, boolean z, boolean z2);

    public static native byte[] encryptPostData(String str, byte[] bArr);
}
