package a.c.d.j.e;

import com.tuya.smart.home.sdk.bean.HomeBean;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f283b;

    /* renamed from: a  reason: collision with root package name */
    public HomeBean f284a;

    public static c b() {
        if (f283b == null) {
            synchronized (c.class) {
                if (f283b == null) {
                    f283b = new c();
                }
            }
        }
        return f283b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.tuya.smart.home.sdk.bean.HomeBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tuya.smart.home.sdk.bean.HomeBean a() {
        /*
            r5 = this;
            com.tuya.smart.home.sdk.bean.HomeBean r0 = r5.f284a
            if (r0 != 0) goto L_0x0045
            a.c.d.a r0 = a.c.d.a.l()
            r1 = 0
            if (r0 == 0) goto L_0x0044
            com.tuya.smart.sdk.api.ITuyaUser r2 = com.tuya.smart.home.sdk.TuyaHomeSdk.getUserInstance()
            com.tuya.smart.android.user.bean.User r2 = r2.getUser()
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = r2.getUid()
            goto L_0x001b
        L_0x001a:
            r2 = r1
        L_0x001b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "currentHome_"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r0 = r0.d(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0037
            goto L_0x0040
        L_0x0037:
            java.lang.Class<com.tuya.smart.home.sdk.bean.HomeBean> r1 = com.tuya.smart.home.sdk.bean.HomeBean.class
            java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r0, r1)
            r1 = r0
            com.tuya.smart.home.sdk.bean.HomeBean r1 = (com.tuya.smart.home.sdk.bean.HomeBean) r1
        L_0x0040:
            r5.c(r1)
            goto L_0x0045
        L_0x0044:
            throw r1
        L_0x0045:
            com.tuya.smart.home.sdk.bean.HomeBean r0 = r5.f284a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.j.e.c.a():com.tuya.smart.home.sdk.bean.HomeBean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0038, code lost:
        if (r1 != r3) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.tuya.smart.home.sdk.bean.HomeBean r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            com.tuya.smart.home.sdk.bean.HomeBean r1 = r8.f284a
            if (r1 != 0) goto L_0x0010
            java.lang.String r0 = "c"
            java.lang.String r1 = "setCurrentHome  currentHome is null so push current home change event"
            android.util.Log.i(r0, r1)
            goto L_0x003a
        L_0x0010:
            long r1 = r1.getHomeId()
            long r3 = r9.getHomeId()
            java.lang.String r5 = "c"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "setCurrentHome: currentHomeId="
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " targetHomeId="
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r5, r6)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            r8.f284a = r9
            a.c.d.a r9 = a.c.d.a.l()
            com.tuya.smart.home.sdk.bean.HomeBean r1 = r8.f284a
            r2 = 0
            if (r9 == 0) goto L_0x008a
            if (r1 != 0) goto L_0x0049
            goto L_0x0064
        L_0x0049:
            com.tuya.smart.sdk.api.ITuyaUser r3 = com.tuya.smart.home.sdk.TuyaHomeSdk.getUserInstance()
            com.tuya.smart.android.user.bean.User r3 = r3.getUser()
            if (r3 == 0) goto L_0x0057
            java.lang.String r2 = r3.getUid()
        L_0x0057:
            java.lang.String r3 = "currentHome_"
            java.lang.String r2 = a.a.a.a.a.k(r3, r2)
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)
            r9.i(r2, r1)
        L_0x0064:
            if (r0 == 0) goto L_0x0089
            e.c.a.c r9 = e.c.a.c.n
            if (r9 != 0) goto L_0x007d
            java.lang.Class<e.c.a.c> r9 = e.c.a.c.class
            monitor-enter(r9)
            e.c.a.c r0 = e.c.a.c.n     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0078
            e.c.a.c r0 = new e.c.a.c     // Catch:{ all -> 0x007a }
            r0.<init>()     // Catch:{ all -> 0x007a }
            e.c.a.c.n = r0     // Catch:{ all -> 0x007a }
        L_0x0078:
            monitor-exit(r9)     // Catch:{ all -> 0x007a }
            goto L_0x007d
        L_0x007a:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x007a }
            throw r0
        L_0x007d:
            e.c.a.c r9 = e.c.a.c.n
            a.c.d.j.e.e.a r0 = new a.c.d.j.e.e.a
            com.tuya.smart.home.sdk.bean.HomeBean r1 = r8.f284a
            r0.<init>(r1)
            r9.c(r0)
        L_0x0089:
            return
        L_0x008a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.j.e.c.c(com.tuya.smart.home.sdk.bean.HomeBean):void");
    }
}
