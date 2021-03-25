package com.tuya.smart.common;

import com.tuya.smart.common.o00o0ooo0o;

public class o00oo000o0 {
    public String O000000o;
    public byte[] O00000Oo;
    public int O00000o;
    public int O00000o0;
    public o00o0ooo0o.O000000o O00000oO;

    public o00oo000o0 O000000o(int i) {
        this.O00000o0 = i;
        return this;
    }

    public o00oo000o0 O000000o(o00o0ooo0o.O000000o o000000o) {
        this.O00000oO = o000000o;
        return this;
    }

    public o00oo000o0 O000000o(String str) {
        this.O000000o = str;
        return this;
    }

    public o00oo000o0 O000000o(byte[] bArr) {
        if (bArr != null) {
            this.O00000Oo = (byte[]) bArr.clone();
        } else {
            this.O00000Oo = null;
        }
        return this;
    }

    public String O000000o() {
        return this.O000000o;
    }

    public o00oo000o0 O00000Oo(int i) {
        this.O00000o = i;
        return this;
    }

    public byte[] O00000Oo() {
        byte[] bArr = this.O00000Oo;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public o00o0ooo0o O00000o() {
        return new o00o0ooo0o(this);
    }

    public int O00000o0() {
        return this.O00000o0;
    }

    public int O00000oO() {
        return this.O00000o;
    }

    public o00o0ooo0o.O000000o O00000oo() {
        return this.O00000oO;
    }
}
