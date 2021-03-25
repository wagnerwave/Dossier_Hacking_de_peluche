package com.tuya.spongycastle.util.encoders;

public class EncoderException extends IllegalStateException {
    public Throwable cause;

    public EncoderException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
