package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class o0O000Oo implements o0o0o0o00o {
    public static final String O000000o = "TuyaGroupCache";
    public static volatile o0O000Oo O00000Oo;
    public Map<Long, GroupRespBean> O00000o0 = new ConcurrentHashMap();

    public static o0O000Oo O000000o() {
        if (O00000Oo == null) {
            synchronized (o0O000Oo.class) {
                if (O00000Oo == null) {
                    O00000Oo = new o0O000Oo();
                }
            }
        }
        return O00000Oo;
    }

    private void O000000o(HashMap<Long, GroupRespBean> hashMap) {
        this.O00000o0.putAll(hashMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void O00000o0(com.tuya.smart.interior.device.bean.GroupRespBean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r5.isDecodeRawed()     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x002a
            r0 = 1
            r5.setDecodeRawed(r0)     // Catch:{ all -> 0x005b }
            java.lang.String r0 = r5.getProductId()     // Catch:{ all -> 0x005b }
            com.tuya.smart.common.oO0O00Oo r1 = com.tuya.smart.common.oO0O00Oo.O000000o()     // Catch:{ all -> 0x005b }
            com.tuya.smart.sdk.bean.ProductBean r0 = r1.O000000o((java.lang.String) r0)     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x002a
            com.tuya.smart.sdk.bean.ProductBean$SchemaInfo r0 = r0.getSchemaInfo()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x002a
            java.util.Map r1 = r5.getDps()     // Catch:{ all -> 0x005b }
            java.util.Map r0 = r0.getSchemaMap()     // Catch:{ all -> 0x005b }
            com.tuya.smart.common.oOO0OO0O.O00000Oo((java.util.Map<java.lang.String, java.lang.Object>) r1, (java.util.Map<java.lang.String, com.tuya.smart.android.device.bean.SchemaBean>) r0)     // Catch:{ all -> 0x005b }
        L_0x002a:
            int r0 = r5.getType()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0032
            monitor-exit(r4)
            return
        L_0x0032:
            java.lang.Class<com.tuya.smart.common.o0o00o0oo0> r0 = com.tuya.smart.common.o0o00o0oo0.class
            java.lang.Object r0 = com.tuya.smart.common.Oo0.O000000o(r0)     // Catch:{ all -> 0x005b }
            com.tuya.smart.common.o0o00o0oo0 r0 = (com.tuya.smart.common.o0o00o0oo0) r0     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0059
            com.tuya.smart.common.o0oo0oo000 r0 = r0.O000000o()     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r1.<init>()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "m/dg/"
            r1.append(r2)     // Catch:{ all -> 0x005b }
            long r2 = r5.getId()     // Catch:{ all -> 0x005b }
            r1.append(r2)     // Catch:{ all -> 0x005b }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x005b }
            r1 = 0
            r0.O00000Oo(r5, r1)     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r4)
            return
        L_0x005b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0O000Oo.O00000o0(com.tuya.smart.interior.device.bean.GroupRespBean):void");
    }

    private void O00000o0(List<GroupRespBean> list) {
        this.O00000o0.clear();
        for (GroupRespBean next : list) {
            StringBuilder n = a.n("subscribe: ");
            n.append(next.getId());
            L.d(O000000o, n.toString());
            O00000o0(next);
            this.O00000o0.put(Long.valueOf(next.getId()), next);
        }
    }

    public GroupBean O000000o(long j) {
        GroupRespBean groupRespBean = this.O00000o0.get(Long.valueOf(j));
        if (groupRespBean == null) {
            return null;
        }
        return oOO0OOo0.O000000o(groupRespBean);
    }

    public void O000000o(GroupRespBean groupRespBean) {
        O00000o0(groupRespBean);
        this.O00000o0.put(Long.valueOf(groupRespBean.getId()), groupRespBean);
    }

    public void O000000o(List<GroupRespBean> list) {
        O00000o0(list);
    }

    public List<GroupBean> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, GroupRespBean> value : this.O00000o0.entrySet()) {
            arrayList.add(oOO0OOo0.O000000o((GroupRespBean) value.getValue()));
        }
        return arrayList;
    }

    public void O00000Oo(long j) {
        this.O00000o0.remove(Long.valueOf(j));
    }

    public void O00000Oo(GroupRespBean groupRespBean) {
        this.O00000o0.put(Long.valueOf(groupRespBean.getId()), groupRespBean);
    }

    public synchronized void O00000Oo(List<GroupRespBean> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (GroupRespBean next : list) {
                L.d(O000000o, "subscribe: " + next.getId());
                O00000o0(next);
                hashMap.put(Long.valueOf(next.getId()), next);
            }
            O000000o((HashMap<Long, GroupRespBean>) hashMap);
        }
    }

    public GroupRespBean O00000o0(long j) {
        return this.O00000o0.get(Long.valueOf(j));
    }

    public void O00000o0() {
        this.O00000o0.clear();
    }
}
