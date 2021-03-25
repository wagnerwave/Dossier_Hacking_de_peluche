package com.tuya.smart.common;

public final class oOOOOO0O {
    public oOOO0o00 O000000o;
    public oOOO0o00 O00000Oo;

    public synchronized oOOO0o00 O000000o() {
        oOOO0o00 oooo0o00;
        oooo0o00 = this.O000000o;
        if (this.O000000o != null) {
            oOOO0o00 oooo0o002 = this.O000000o.O00000o0;
            this.O000000o = oooo0o002;
            if (oooo0o002 == null) {
                this.O00000Oo = null;
            }
        }
        return oooo0o00;
    }

    public synchronized oOOO0o00 O000000o(int i) {
        if (this.O000000o == null) {
            wait((long) i);
        }
        return O000000o();
    }

    public synchronized void O000000o(oOOO0o00 oooo0o00) {
        if (oooo0o00 != null) {
            try {
                if (this.O00000Oo != null) {
                    this.O00000Oo.O00000o0 = oooo0o00;
                    this.O00000Oo = oooo0o00;
                } else if (this.O000000o == null) {
                    this.O00000Oo = oooo0o00;
                    this.O000000o = oooo0o00;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }
}
