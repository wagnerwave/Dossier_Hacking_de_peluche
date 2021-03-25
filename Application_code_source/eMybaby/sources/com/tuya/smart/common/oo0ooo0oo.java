package com.tuya.smart.common;

public final class oo0ooo0oo extends oo0oo0oo0 {
    public static final String O00000Oo = "ConfigNetworkTransmitSetAction";
    public static final int O00000o0 = 32804;
    public final int O00000o;
    public final int O00000oO;

    public oo0ooo0oo(int i, int i2) {
        if (i < 0 || 7 < i) {
            throw new IllegalArgumentException("Network Transmit Count must be between 0 and 7 (inclusive)");
        } else if (i2 < 0 || 31 < i2) {
            throw new IllegalArgumentException("Network Transmit Interval Steps must be between 0 and 31 (inclusive)");
        } else {
            this.O00000o = i;
            this.O00000oO = i2;
        }
    }

    public byte[] O000000o() {
        return new byte[]{(byte) (((this.O00000oO << 3) & 255) | (this.O00000o & 255))};
    }

    public int O00000Oo() {
        return 32804;
    }

    public int O00000o0() {
        return 32805;
    }

    public int O0000O0o() {
        return this.O00000o;
    }

    public int O0000OOo() {
        return this.O00000oO;
    }
}
