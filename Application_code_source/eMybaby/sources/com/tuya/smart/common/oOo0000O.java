package com.tuya.smart.common;

import a.a.a.a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.Iterator;

public class oOo0000O {
    public static final String O000000o = "TuyaMessageCache";
    public final long O00000Oo = 5000;
    public HashMap<String, Long> O00000o = new HashMap<>(1000);
    public HashMap<String, Long> O00000o0 = new HashMap<>(600);

    public static class O000000o {
        public static oOo0000O O000000o = new oOo0000O();
    }

    public static oOo0000O O000000o() {
        return O000000o.O000000o;
    }

    private boolean O000000o(String str) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev != null) {
            boolean z = (dev.getAttribute() & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) > 0;
            L.d(O000000o, z ? "the device is lowPower with dataUpdate false" : "the device is not lowPower ");
            return !z;
        }
        L.d(O000000o, "the device is ==null");
        return true;
    }

    private boolean O00000Oo(String str, int i) {
        if (i == -1) {
            return true;
        }
        String h = a.h(str, i);
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.O00000o0.get(h);
        if (l == null || TuyaUtil.absoluteValue(currentTimeMillis - l.longValue()) >= 5000) {
            if (this.O00000o0.size() > 300) {
                Iterator<String> it = this.O00000o0.keySet().iterator();
                while (it.hasNext()) {
                    if (TuyaUtil.absoluteValue(currentTimeMillis - this.O00000o0.get(it.next()).longValue()) >= 5000) {
                        it.remove();
                    }
                }
            }
            this.O00000o0.put(h, Long.valueOf(currentTimeMillis));
            return false;
        }
        this.O00000o0.remove(h);
        return true;
    }

    private synchronized boolean O00000Oo(String str, int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        L.d(O000000o, "gwId: " + str + " s: " + i + " r: " + i2);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(i2);
        String sb2 = sb.toString();
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.O00000o.get(sb2);
        if (l == null || TuyaUtil.absoluteValue(currentTimeMillis - l.longValue()) >= 5000) {
            if (this.O00000o.size() > 900) {
                Iterator<String> it = this.O00000o.keySet().iterator();
                while (it.hasNext()) {
                    if (TuyaUtil.absoluteValue(currentTimeMillis - this.O00000o.get(it.next()).longValue()) >= 5000) {
                        it.remove();
                    }
                }
            }
            this.O00000o.put(sb2, Long.valueOf(currentTimeMillis));
            return false;
        }
        this.O00000o.remove(sb2);
        return true;
    }

    public synchronized boolean O000000o(String str, int i) {
        boolean O00000Oo2;
        O00000Oo2 = O00000Oo(str, i);
        if (O00000Oo2) {
            O00000Oo2 = O000000o(str);
        } else {
            L.d(O000000o, "the dps isDataUpdated == false");
        }
        return O00000Oo2;
    }

    public synchronized boolean O000000o(String str, int i, int i2) {
        boolean O00000Oo2;
        O00000Oo2 = O00000Oo(str, i, i2);
        if (O00000Oo2) {
            O00000Oo2 = O000000o(str);
        } else {
            L.d(O000000o, "the dps isDataUpdated == false");
        }
        L.d(O000000o, "dated: " + O00000Oo2);
        return O00000Oo2;
    }
}
