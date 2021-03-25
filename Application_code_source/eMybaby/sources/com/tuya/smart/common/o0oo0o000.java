package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.user.bean.User;

public class o0oo0o000 implements o0oo0oo00 {
    public String O000000o() {
        User user;
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null || (user = o0o00oo0oo.O000000o().getUser()) == null) {
            return "";
        }
        StringBuilder n = a.n(o0O00Oo0.O00000o);
        n.append(user.getUid());
        return n.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.O000000o().getUser();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O00000Oo() {
        /*
            r1 = this;
            java.lang.Class<com.tuya.smart.common.o0o00oo0oo> r0 = com.tuya.smart.common.o0o00oo0oo.class
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00oo0oo r0 = (com.tuya.smart.common.o0o00oo0oo) r0
            if (r0 == 0) goto L_0x0019
            com.tuya.smart.sdk.api.ITuyaUser r0 = r0.O000000o()
            com.tuya.smart.android.user.bean.User r0 = r0.getUser()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getSid()
            return r0
        L_0x0019:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0oo0o000.O00000Oo():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.O000000o().getUser();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String O00000o0() {
        /*
            r3 = this;
            java.lang.Class<com.tuya.smart.common.o0o00oo0oo> r0 = com.tuya.smart.common.o0o00oo0oo.class
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)
            com.tuya.smart.common.o0o00oo0oo r0 = (com.tuya.smart.common.o0o00oo0oo) r0
            if (r0 == 0) goto L_0x0025
            com.tuya.smart.sdk.api.ITuyaUser r0 = r0.O000000o()
            com.tuya.smart.android.user.bean.User r0 = r0.getUser()
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getEcode()
            java.lang.String r0 = com.tuya.smart.android.common.utils.MD5Util.md5AsBase64((java.lang.String) r0)
            r1 = 8
            r2 = 24
            java.lang.String r0 = r0.substring(r1, r2)
            return r0
        L_0x0025:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0oo0o000.O00000o0():java.lang.String");
    }
}
