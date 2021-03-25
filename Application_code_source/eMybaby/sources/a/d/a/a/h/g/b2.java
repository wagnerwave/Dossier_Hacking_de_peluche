package a.d.a.a.h.g;

public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s2<Boolean> f1609a = r2.f1911a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f1610b = new Object();

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r4, android.net.Uri r5) {
        /*
            java.lang.String r5 = r5.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r5)
            r1 = 0
            if (r0 != 0) goto L_0x002e
            java.lang.String r4 = "PhenotypeClientHelper"
            java.lang.String r0 = java.lang.String.valueOf(r5)
            int r0 = r0.length()
            int r0 = r0 + 91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r2.append(r5)
            java.lang.String r5 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r4, r5)
            return r1
        L_0x002e:
            a.d.a.a.h.g.s2<java.lang.Boolean> r5 = f1609a
            boolean r5 = r5.b()
            if (r5 == 0) goto L_0x0043
        L_0x0036:
            a.d.a.a.h.g.s2<java.lang.Boolean> r4 = f1609a
            java.lang.Object r4 = r4.c()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L_0x0043:
            java.lang.Object r5 = f1610b
            monitor-enter(r5)
            a.d.a.a.h.g.s2<java.lang.Boolean> r0 = f1609a     // Catch:{ all -> 0x00a7 }
            boolean r0 = r0.b()     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x005c
            a.d.a.a.h.g.s2<java.lang.Boolean> r4 = f1609a     // Catch:{ all -> 0x00a7 }
            java.lang.Object r4 = r4.c()     // Catch:{ all -> 0x00a7 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00a7 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00a7 }
            monitor-exit(r5)     // Catch:{ all -> 0x00a7 }
            return r4
        L_0x005c:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r4.getPackageName()     // Catch:{ all -> 0x00a7 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00a7 }
            r2 = 1
            if (r0 == 0) goto L_0x006b
        L_0x0069:
            r0 = 1
            goto L_0x0083
        L_0x006b:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "com.google.android.gms.phenotype"
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r3, r1)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0082
            java.lang.String r3 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch:{ all -> 0x00a7 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x0082
            goto L_0x0069
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 == 0) goto L_0x009b
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x0097 }
            int r4 = r4.flags     // Catch:{ all -> 0x00a7 }
            r4 = r4 & 129(0x81, float:1.81E-43)
            if (r4 == 0) goto L_0x0097
            r4 = 1
            goto L_0x0098
        L_0x0097:
            r4 = 0
        L_0x0098:
            if (r4 == 0) goto L_0x009b
            r1 = 1
        L_0x009b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00a7 }
            a.d.a.a.h.g.s2 r4 = a.d.a.a.h.g.s2.a(r4)     // Catch:{ all -> 0x00a7 }
            f1609a = r4     // Catch:{ all -> 0x00a7 }
            monitor-exit(r5)     // Catch:{ all -> 0x00a7 }
            goto L_0x0036
        L_0x00a7:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00a7 }
            goto L_0x00ab
        L_0x00aa:
            throw r4
        L_0x00ab:
            goto L_0x00aa
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.b2.a(android.content.Context, android.net.Uri):boolean");
    }
}
