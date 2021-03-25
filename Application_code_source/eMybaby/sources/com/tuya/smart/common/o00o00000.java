package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.hardware.bean.HgwBean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class o00o00000 {
    public static final String O000000o = "TuyaHgwBeanCacheManager";
    public static volatile o00o00000 O00000Oo;
    public Map<String, HgwBean> O00000o0 = new ConcurrentHashMap();

    public static o00o00000 O000000o() {
        if (O00000Oo == null) {
            synchronized (o00o00000.class) {
                if (O00000Oo == null) {
                    O00000Oo = new o00o00000();
                }
            }
        }
        return O00000Oo;
    }

    public HgwBean O000000o(String str) {
        if (str == null) {
            return null;
        }
        return this.O00000o0.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void O000000o(java.lang.String r2, com.tuya.smart.android.hardware.bean.HgwBean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0011
            if (r3 != 0) goto L_0x000a
            goto L_0x0011
        L_0x000a:
            java.util.Map<java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean> r0 = r1.O00000o0     // Catch:{ all -> 0x0013 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00o00000.O000000o(java.lang.String, com.tuya.smart.android.hardware.bean.HgwBean):void");
    }

    public synchronized void O00000Oo() {
        this.O00000o0.clear();
    }

    public synchronized void O00000Oo(String str) {
        L.d(O000000o, "removeHgwBean devId: " + str);
        this.O00000o0.remove(str);
    }
}
