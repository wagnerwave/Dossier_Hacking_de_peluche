package com.tuya.smart.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tuya.sdk.eventbus.EventBusException;

public final class oOOO0O0o extends Handler {
    public final oOOOOO0O O000000o = new oOOOOO0O();
    public final int O00000Oo;
    public boolean O00000o;
    public final oOOO00o0 O00000o0;

    public oOOO0O0o(oOOO00o0 oooo00o0, Looper looper, int i) {
        super(looper);
        this.O00000o0 = oooo00o0;
        this.O00000Oo = i;
    }

    public void O000000o(o0000000o o0000000o, Object obj) {
        oOOO0o00 O000000o2 = oOOO0o00.O000000o(o0000000o, obj);
        synchronized (this) {
            this.O000000o.O000000o(O000000o2);
            if (!this.O00000o) {
                this.O00000o = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                oOOO0o00 O000000o2 = this.O000000o.O000000o();
                if (O000000o2 == null) {
                    synchronized (this) {
                        O000000o2 = this.O000000o.O000000o();
                        if (O000000o2 == null) {
                            this.O00000o = false;
                            this.O00000o = false;
                            return;
                        }
                    }
                }
                this.O00000o0.O000000o(O000000o2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.O00000Oo));
            if (sendMessage(obtainMessage())) {
                this.O00000o = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.O00000o = false;
            throw th;
        }
    }
}
