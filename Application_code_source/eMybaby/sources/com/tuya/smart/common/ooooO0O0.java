package com.tuya.smart.common;

public class ooooO0O0 implements Runnable {
    public final oOOOOO0O O000000o = new oOOOOO0O();
    public final oOOO00o0 O00000Oo;

    public ooooO0O0(oOOO00o0 oooo00o0) {
        this.O00000Oo = oooo00o0;
    }

    public void O000000o(o0000000o o0000000o, Object obj) {
        this.O000000o.O000000o(oOOO0o00.O000000o(o0000000o, obj));
        this.O00000Oo.O00000oO().execute(this);
    }

    public void run() {
        oOOO0o00 O000000o2 = this.O000000o.O000000o();
        if (O000000o2 != null) {
            this.O00000Oo.O000000o(O000000o2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
