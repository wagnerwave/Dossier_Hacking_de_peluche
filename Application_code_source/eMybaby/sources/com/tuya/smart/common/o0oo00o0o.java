package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.common.utils.L;

public class o0oo00o0o {
    public static final o0oo00o0o O000000o = new o0oo00o0o();
    public static final String O00000Oo = "MqttTimeManager";
    public long O00000o0 = -1;

    public static o0oo00o0o O000000o() {
        return O000000o;
    }

    public long O00000Oo() {
        StringBuilder n = a.n("closedRetryTime: ");
        n.append(this.O00000o0);
        L.mqtt(O00000Oo, n.toString());
        long j = this.O00000o0;
        if (j > 30000) {
            return j;
        }
        if (j == -1) {
            this.O00000o0 = 0;
        } else {
            this.O00000o0 = j == 0 ? 1500 : j << 1;
        }
        return this.O00000o0 >> 1;
    }

    public void O00000o0() {
        this.O00000o0 = -1;
        StringBuilder n = a.n("reset close RetryTime: ");
        n.append(this.O00000o0);
        L.mqtt(O00000Oo, n.toString());
    }
}
