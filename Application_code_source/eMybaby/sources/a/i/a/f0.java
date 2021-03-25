package a.i.a;

import android.content.Context;

public class f0 implements j {

    /* renamed from: b  reason: collision with root package name */
    public static volatile Object f3602b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f3603c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f3604d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3605a;

    public static class a extends ThreadLocal<StringBuilder> {
        public Object initialValue() {
            return new StringBuilder();
        }
    }

    public f0(Context context) {
        this.f3605a = context.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d2, code lost:
        if (java.lang.Integer.parseInt(r8[1]) == 304) goto L_0x00d6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.i.a.j.a a(android.net.Uri r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3605a
            java.lang.Object r1 = f3602b
            if (r1 != 0) goto L_0x0027
            java.lang.Object r1 = f3603c     // Catch:{ IOException -> 0x0026 }
            monitor-enter(r1)     // Catch:{ IOException -> 0x0026 }
            java.lang.Object r2 = f3602b     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0021
            java.io.File r0 = a.i.a.g0.f(r0)     // Catch:{ all -> 0x0023 }
            android.net.http.HttpResponseCache r2 = android.net.http.HttpResponseCache.getInstalled()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x001f
            long r2 = a.i.a.g0.a(r0)     // Catch:{ all -> 0x0023 }
            android.net.http.HttpResponseCache r2 = android.net.http.HttpResponseCache.install(r0, r2)     // Catch:{ all -> 0x0023 }
        L_0x001f:
            f3602b = r2     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            throw r0     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
        L_0x0027:
            java.net.URL r0 = new java.net.URL
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            java.net.URLConnection r7 = r0.openConnection()
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            r0 = 15000(0x3a98, float:2.102E-41)
            r7.setConnectTimeout(r0)
            r0 = 20000(0x4e20, float:2.8026E-41)
            r7.setReadTimeout(r0)
            r0 = 1
            r7.setUseCaches(r0)
            r1 = 0
            if (r8 == 0) goto L_0x0091
            boolean r2 = a.i.a.q.f(r8)
            if (r2 == 0) goto L_0x0050
            java.lang.String r2 = "only-if-cached,max-age=2147483647"
            goto L_0x008c
        L_0x0050:
            java.lang.ThreadLocal<java.lang.StringBuilder> r2 = f3604d
            java.lang.Object r2 = r2.get()
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            r2.setLength(r1)
            a.i.a.q r3 = a.i.a.q.NO_CACHE
            int r3 = r3.f3649a
            r3 = r3 & r8
            if (r3 != 0) goto L_0x0064
            r3 = 1
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 != 0) goto L_0x006c
            java.lang.String r3 = "no-cache"
            r2.append(r3)
        L_0x006c:
            a.i.a.q r3 = a.i.a.q.NO_STORE
            int r3 = r3.f3649a
            r3 = r3 & r8
            if (r3 != 0) goto L_0x0075
            r3 = 1
            goto L_0x0076
        L_0x0075:
            r3 = 0
        L_0x0076:
            if (r3 != 0) goto L_0x0088
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0083
            r3 = 44
            r2.append(r3)
        L_0x0083:
            java.lang.String r3 = "no-store"
            r2.append(r3)
        L_0x0088:
            java.lang.String r2 = r2.toString()
        L_0x008c:
            java.lang.String r3 = "Cache-Control"
            r7.setRequestProperty(r3, r2)
        L_0x0091:
            int r2 = r7.getResponseCode()
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 >= r3) goto L_0x00e0
            java.lang.String r8 = "Content-Length"
            r2 = -1
            int r8 = r7.getHeaderFieldInt(r8, r2)
            long r2 = (long) r8
            java.lang.String r8 = "X-Android-Response-Source"
            java.lang.String r8 = r7.getHeaderField(r8)
            if (r8 != 0) goto L_0x00aa
            goto L_0x00d5
        L_0x00aa:
            r4 = 2
            java.lang.String r5 = " "
            java.lang.String[] r8 = r8.split(r5, r4)
            r4 = r8[r1]
            java.lang.String r5 = "CACHE"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00bc
            goto L_0x00d6
        L_0x00bc:
            int r4 = r8.length
            if (r4 != r0) goto L_0x00c0
            goto L_0x00d5
        L_0x00c0:
            java.lang.String r4 = "CONDITIONAL_CACHE"
            r5 = r8[r1]     // Catch:{ NumberFormatException -> 0x00d5 }
            boolean r4 = r4.equals(r5)     // Catch:{ NumberFormatException -> 0x00d5 }
            if (r4 == 0) goto L_0x00d5
            r8 = r8[r0]     // Catch:{ NumberFormatException -> 0x00d5 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00d5 }
            r4 = 304(0x130, float:4.26E-43)
            if (r8 != r4) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r0 = 0
        L_0x00d6:
            a.i.a.j$a r8 = new a.i.a.j$a
            java.io.InputStream r7 = r7.getInputStream()
            r8.<init>(r7, r0, r2)
            return r8
        L_0x00e0:
            r7.disconnect()
            a.i.a.j$b r0 = new a.i.a.j$b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r3 = " "
            r1.append(r3)
            java.lang.String r7 = r7.getResponseMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7, r8, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.f0.a(android.net.Uri, int):a.i.a.j$a");
    }
}
