package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ooOOO00O implements o0o0o000o0, o0oo0ooo0o {
    public static final String O000000o = "TuyaSmartServerManager";
    public final oO00O0Oo O00000Oo = new oO00O0Oo();
    public volatile boolean O00000o;
    public o0oo0oo000 O00000o0;
    public HashMap<Class, CopyOnWriteArrayList<o0o0o00000>> O00000oO = new HashMap<>();

    public String O000000o(String str) {
        if (str.startsWith(o0O00Oo0.O00000oO)) {
            GroupBean O000000o2 = o0O000Oo.O000000o().O000000o(Long.parseLong(str.replace(o0O00Oo0.O00000oO, "")));
            if (O000000o2 != null) {
                return O000000o2.getLocalKey();
            }
            return null;
        } else if (!str.startsWith("smart/mb/in/")) {
            return null;
        } else {
            String replace = str.replace("smart/mb/in/", "");
            DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(replace);
            if (O00000Oo2 != null) {
                return O00000Oo2.getLocalKey();
            }
            o0o000oooo o0o000oooo = (o0o000oooo) Oo0.O000000o(o0o000oooo.class);
            if (o0o000oooo == null) {
                return null;
            }
            BlueMeshBean blueMeshBean = o0o000oooo.O000000o().getBlueMeshBean(replace);
            if (blueMeshBean == null) {
                blueMeshBean = o0o000oooo.O00000Oo().getSigMeshBean(replace);
            }
            if (blueMeshBean != null) {
                return blueMeshBean.getLocalKey();
            }
            return null;
        }
    }

    public void O000000o() {
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null || o0o00oo0oo.O000000o().isLogin()) {
            StringBuilder n = a.n("startConnectMqttServer");
            n.append(this.O00000o);
            L.d(O000000o, n.toString());
            if (!this.O00000o) {
                this.O00000o = true;
                o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
                if (o0o00o0oo0 != null) {
                    this.O00000o0 = o0o00o0oo0.O000000o();
                }
                o0oo0oo000 o0oo0oo000 = this.O00000o0;
                if (o0oo0oo000 != null) {
                    o0oo0oo000.O00000Oo();
                    this.O00000o0.O000000o((o0oo0ooo0o) this);
                    return;
                }
                return;
            }
            return;
        }
        L.d(O000000o, "startConnectMqttServer failure with in not login status");
    }

    public <T> void O000000o(Class<T> cls, o0o0o00000<T> o0o0o00000) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.O00000oO.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        if (!copyOnWriteArrayList.contains(o0o0o00000)) {
            copyOnWriteArrayList.add(o0o0o00000);
            this.O00000oO.put(cls, copyOnWriteArrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r4.startsWith(r0) != false) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O000000o(final java.lang.String r4, final int r5, final com.alibaba.fastjson.JSONObject r6) {
        /*
            r3 = this;
            java.lang.String r0 = "smart/mb/in/"
            boolean r1 = r4.startsWith(r0)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000f
        L_0x000a:
            java.lang.String r4 = r4.replace(r0, r2)
            goto L_0x0021
        L_0x000f:
            java.lang.String r0 = "m/dg/"
            boolean r1 = r4.startsWith(r0)
            if (r1 == 0) goto L_0x0018
            goto L_0x000a
        L_0x0018:
            java.lang.String r0 = "m/ug/"
            boolean r1 = r4.startsWith(r0)
            if (r1 == 0) goto L_0x0021
            goto L_0x000a
        L_0x0021:
            com.tuya.smart.common.ooOOO00O$1 r0 = new com.tuya.smart.common.ooOOO00O$1
            r0.<init>(r5, r4, r6)
            android.os.AsyncTask.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.ooOOO00O.O000000o(java.lang.String, int, com.alibaba.fastjson.JSONObject):void");
    }

    public void O000000o(String str, String str2, String str3) {
        L.e(O000000o, "mqtt dp received topicId: " + str + " errorCode: " + str2 + " errorMsg:" + str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r4.startsWith(r0) != false) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O000000o(java.lang.String r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "smart/mb/in/"
            boolean r1 = r4.startsWith(r0)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000f
        L_0x000a:
            java.lang.String r4 = r4.replace(r0, r2)
            goto L_0x0021
        L_0x000f:
            java.lang.String r0 = "m/dg/"
            boolean r1 = r4.startsWith(r0)
            if (r1 == 0) goto L_0x0018
            goto L_0x000a
        L_0x0018:
            java.lang.String r0 = "m/ug/"
            boolean r1 = r4.startsWith(r0)
            if (r1 == 0) goto L_0x0021
            goto L_0x000a
        L_0x0021:
            com.tuya.smart.common.oOo0000O r0 = com.tuya.smart.common.oOo0000O.O000000o()
            boolean r4 = r0.O000000o(r4, r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.ooOOO00O.O000000o(java.lang.String, int, int):boolean");
    }

    public <T> void O00000Oo(Class<T> cls, o0o0o00000<T> o0o0o00000) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.O00000oO.get(cls);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(o0o0o00000);
        }
    }

    public String[] O00000Oo() {
        return new String[]{"smart/mb/in/", o0O00Oo0.O00000oO};
    }

    public void O00000o() {
        StringBuilder n = a.n("stopMqttServerService");
        n.append(this.O00000o);
        L.d(O000000o, n.toString());
        if (this.O00000o) {
            o0oo0oo000 o0oo0oo000 = this.O00000o0;
            if (o0oo0oo000 != null) {
                o0oo0oo000.O00000o0();
                this.O00000o0.O00000Oo((o0oo0ooo0o) this);
                this.O00000oO.clear();
            }
            this.O00000o = false;
        }
    }

    public boolean O00000o0() {
        o0oo0oo000 o0oo0oo000 = this.O00000o0;
        return o0oo0oo000 != null && o0oo0oo000.O00000o();
    }
}
