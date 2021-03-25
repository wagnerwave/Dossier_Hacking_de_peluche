package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class oo0oo0o00 extends oo0oo0oo0 {
    public static final int O00000Oo = 0;
    public o000o0o0o0 O00000o;
    public NetworkKey O00000o0;

    public oo0oo0o00(String str, NetworkKey networkKey, o000o0o0o0 o000o0o0o0, o000oo0000 o000oo0000, o00o0o0o0o.O000000o o000000o) {
        super(str, o000000o, o000oo0000);
        this.O00000o0 = networkKey;
        this.O00000o = o000o0o0o0;
    }

    public byte[] O000000o() {
        byte[] O000000o = o00o0000oo.O000000o(Integer.valueOf(this.O00000o0.getKeyIndex()));
        byte[] O000000o2 = o00o0000oo.O000000o(Integer.valueOf(this.O00000o.O00000oO()));
        ByteBuffer order = ByteBuffer.allocate(19).order(ByteOrder.BIG_ENDIAN);
        order.put(O000000o[1]);
        order.put((byte) ((O000000o[0] & 15) | (O000000o2[1] << 4)));
        order.put((byte) ((O000000o2[0] << 4) | (O000000o2[1] >> 4)));
        order.put(this.O00000o.O00000o());
        return order.array();
    }

    public int O00000Oo() {
        return 0;
    }

    public int O00000o0() {
        return 32771;
    }
}
