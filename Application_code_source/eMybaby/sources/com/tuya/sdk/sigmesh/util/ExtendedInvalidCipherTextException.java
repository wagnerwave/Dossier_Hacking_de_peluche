package com.tuya.sdk.sigmesh.util;

import com.tuya.spongycastle.crypto.InvalidCipherTextException;

public class ExtendedInvalidCipherTextException extends InvalidCipherTextException {
    public final Throwable cause;
    public final String message;
    public final String tag;

    public ExtendedInvalidCipherTextException(String str, Throwable th, String str2) {
        this.message = str;
        this.cause = th;
        this.tag = str2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTag() {
        return this.tag;
    }
}
