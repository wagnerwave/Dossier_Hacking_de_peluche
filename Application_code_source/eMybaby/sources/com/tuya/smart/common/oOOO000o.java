package com.tuya.smart.common;

import android.util.Log;

public final class oOOO000o implements Runnable {
    public final oOOOOO0O O000000o = new oOOOOO0O();
    public final oOOO00o0 O00000Oo;
    public volatile boolean O00000o0;

    public oOOO000o(oOOO00o0 oooo00o0) {
        this.O00000Oo = oooo00o0;
    }

    public void O000000o(o0000000o o0000000o, Object obj) {
        oOOO0o00 O000000o2 = oOOO0o00.O000000o(o0000000o, obj);
        synchronized (this) {
            this.O000000o.O000000o(O000000o2);
            if (!this.O00000o0) {
                this.O00000o0 = true;
                this.O00000Oo.O00000oO().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                oOOO0o00 O000000o2 = this.O000000o.O000000o(1000);
                if (O000000o2 == null) {
                    synchronized (this) {
                        O000000o2 = this.O000000o.O000000o();
                        if (O000000o2 == null) {
                            this.O00000o0 = false;
                            this.O00000o0 = false;
                            return;
                        }
                    }
                }
                this.O00000Oo.O000000o(O000000o2);
            } catch (InterruptedException e2) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e2);
                    return;
                } finally {
                    this.O00000o0 = false;
                }
            }
        }
    }
}
