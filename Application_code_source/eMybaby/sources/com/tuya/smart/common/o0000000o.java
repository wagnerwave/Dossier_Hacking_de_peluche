package com.tuya.smart.common;

public final class o0000000o {
    public final Object O000000o;
    public final oo000000 O00000Oo;
    public volatile boolean O00000o = true;
    public final int O00000o0;

    public o0000000o(Object obj, oo000000 oo000000, int i) {
        this.O000000o = obj;
        this.O00000Oo = oo000000;
        this.O00000o0 = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0000000o)) {
            return false;
        }
        o0000000o o0000000o = (o0000000o) obj;
        return this.O000000o == o0000000o.O000000o && this.O00000Oo.equals(o0000000o.O00000Oo);
    }

    public int hashCode() {
        return this.O00000Oo.O00000o.hashCode() + this.O000000o.hashCode();
    }
}
