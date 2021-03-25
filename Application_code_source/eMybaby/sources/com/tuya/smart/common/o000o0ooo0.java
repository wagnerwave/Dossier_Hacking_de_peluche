package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.Message;
import java.nio.ByteBuffer;

public abstract class o000o0ooo0 {
    public final int O000000o = 0;
    public byte[] O00000o;
    public Message O00000o0;

    public abstract int B_();

    public void O000000o(Message message) {
        this.O00000o0 = message;
    }

    public abstract int O00000Oo();

    public abstract int O00000o0();

    public Message O0000o() {
        return this.O00000o0;
    }

    public final int O0000o0o() {
        return 0;
    }

    public byte[] O0000oO() {
        return this.O00000o0.getDst();
    }

    public byte[] O0000oO0() {
        return this.O00000o0.getSrc();
    }

    public int O0000oOO() {
        return ByteBuffer.wrap(this.O00000o0.getSrc()).getShort();
    }

    public abstract byte[] j_();
}
