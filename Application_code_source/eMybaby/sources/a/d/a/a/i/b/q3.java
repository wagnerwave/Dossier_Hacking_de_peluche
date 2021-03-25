package a.d.a.a.i.b;

import java.util.List;

public final class q3 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public String f2474c;

    /* renamed from: d  reason: collision with root package name */
    public String f2475d;

    /* renamed from: e  reason: collision with root package name */
    public int f2476e;
    public String f;
    public long g;
    public long h;
    public List<String> i;
    public int j;
    public String k;
    public String l;
    public String m;

    public q3(c5 c5Var, long j2) {
        super(c5Var);
        this.h = j2;
    }

    public final boolean w() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e2 A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0202 A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x025e A[SYNTHETIC, Splitter:B:123:0x025e] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0161 A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x016f A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017d A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x017f A[Catch:{ IllegalStateException -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x018c A[SYNTHETIC, Splitter:B:80:0x018c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r14 = this;
            a.d.a.a.i.b.c5 r0 = r14.f2563a
            android.content.Context r0 = r0.f2123a
            java.lang.String r0 = r0.getPackageName()
            a.d.a.a.i.b.c5 r1 = r14.f2563a
            android.content.Context r1 = r1.f2123a
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002b
            a.d.a.a.i.b.x3 r7 = r14.i()
            a.d.a.a.i.b.z3 r7 = r7.f
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.b(r9, r8)
            goto L_0x0086
        L_0x002b:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0030 }
            goto L_0x003f
        L_0x0030:
            a.d.a.a.i.b.x3 r7 = r14.i()
            a.d.a.a.i.b.z3 r7 = r7.f
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.b(r9, r8)
        L_0x003f:
            if (r5 != 0) goto L_0x0044
            java.lang.String r5 = "manual_install"
            goto L_0x004d
        L_0x0044:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x004d
            r5 = r3
        L_0x004d:
            a.d.a.a.i.b.c5 r7 = r14.f2563a     // Catch:{ NameNotFoundException -> 0x0075 }
            android.content.Context r7 = r7.f2123a     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0075 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0075 }
            if (r7 == 0) goto L_0x0086
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0075 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0075 }
            if (r9 != 0) goto L_0x006c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0075 }
            goto L_0x006d
        L_0x006c:
            r8 = r2
        L_0x006d:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0072 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0072 }
            goto L_0x0086
        L_0x0072:
            r7 = r2
            r2 = r8
            goto L_0x0076
        L_0x0075:
            r7 = r2
        L_0x0076:
            a.d.a.a.i.b.x3 r8 = r14.i()
            a.d.a.a.i.b.z3 r8 = r8.f
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.c(r10, r9, r2)
            r2 = r7
        L_0x0086:
            r14.f2474c = r0
            r14.f = r5
            r14.f2475d = r2
            r14.f2476e = r6
            r5 = 0
            r14.g = r5
            a.d.a.a.i.b.c5 r2 = r14.f2563a
            android.content.Context r2 = r2.f2123a
            com.google.android.gms.common.api.Status r2 = a.d.a.a.e.k.l.g.b(r2)
            r5 = 1
            if (r2 == 0) goto L_0x00a5
            boolean r6 = r2.e()
            if (r6 == 0) goto L_0x00a5
            r6 = 1
            goto L_0x00a6
        L_0x00a5:
            r6 = 0
        L_0x00a6:
            a.d.a.a.i.b.c5 r7 = r14.f2563a
            java.lang.String r7 = r7.f2124b
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00be
            a.d.a.a.i.b.c5 r7 = r14.f2563a
            java.lang.String r7 = r7.f2125c
            java.lang.String r8 = "am"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00be
            r7 = 1
            goto L_0x00bf
        L_0x00be:
            r7 = 0
        L_0x00bf:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x00e3
            if (r2 != 0) goto L_0x00d0
            a.d.a.a.i.b.x3 r2 = r14.i()
            a.d.a.a.i.b.z3 r2 = r2.g
            java.lang.String r8 = "GoogleService failed to initialize (no status)"
            r2.a(r8)
            goto L_0x00e3
        L_0x00d0:
            a.d.a.a.i.b.x3 r8 = r14.i()
            a.d.a.a.i.b.z3 r8 = r8.g
            int r9 = r2.f4207b
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.f4208c
            java.lang.String r10 = "GoogleService failed to initialize, status"
            r8.c(r10, r9, r2)
        L_0x00e3:
            if (r6 == 0) goto L_0x0137
            a.d.a.a.i.b.c5 r2 = r14.f2563a
            int r2 = r2.e()
            a.d.a.a.i.b.x3 r6 = r14.i()
            switch(r2) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0116;
                case 2: goto L_0x0111;
                case 3: goto L_0x010c;
                case 4: goto L_0x0107;
                case 5: goto L_0x0102;
                case 6: goto L_0x00fd;
                case 7: goto L_0x00f8;
                case 8: goto L_0x00f3;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x0123
        L_0x00f3:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            goto L_0x011f
        L_0x00f8:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            goto L_0x011f
        L_0x00fd:
            a.d.a.a.i.b.z3 r6 = r6.k
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            goto L_0x011f
        L_0x0102:
            a.d.a.a.i.b.z3 r6 = r6.n
            java.lang.String r8 = "App measurement disabled via the init parameters"
            goto L_0x011f
        L_0x0107:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement disabled via the manifest"
            goto L_0x011f
        L_0x010c:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            goto L_0x011f
        L_0x0111:
            a.d.a.a.i.b.z3 r6 = r6.n
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            goto L_0x011f
        L_0x0116:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement deactivated via the manifest"
            goto L_0x011f
        L_0x011b:
            a.d.a.a.i.b.z3 r6 = r6.n
            java.lang.String r8 = "App measurement collection enabled"
        L_0x011f:
            r6.a(r8)
            goto L_0x0133
        L_0x0123:
            a.d.a.a.i.b.z3 r6 = r6.l
            java.lang.String r8 = "App measurement disabled"
            r6.a(r8)
            a.d.a.a.i.b.x3 r6 = r14.i()
            a.d.a.a.i.b.z3 r6 = r6.g
            java.lang.String r8 = "Invalid scion state in identity"
            goto L_0x011f
        L_0x0133:
            if (r2 != 0) goto L_0x0137
            r2 = 1
            goto L_0x0138
        L_0x0137:
            r2 = 0
        L_0x0138:
            r14.k = r3
            r14.l = r3
            r14.m = r3
            if (r7 == 0) goto L_0x0146
            a.d.a.a.i.b.c5 r6 = r14.f2563a
            java.lang.String r6 = r6.f2124b
            r14.l = r6
        L_0x0146:
            r6 = 0
            a.d.a.a.h.g.tc r7 = a.d.a.a.h.g.tc.f1954b     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.Object r7 = r7.a()     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.h.g.sc r7 = (a.d.a.a.h.g.sc) r7     // Catch:{ IllegalStateException -> 0x016c }
            boolean r7 = r7.a()     // Catch:{ IllegalStateException -> 0x016c }
            if (r7 == 0) goto L_0x016f
            a.d.a.a.i.b.c5 r7 = r14.f2563a     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.i.b.ka r7 = r7.g     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.K0     // Catch:{ IllegalStateException -> 0x016c }
            boolean r7 = r7.o(r8)     // Catch:{ IllegalStateException -> 0x016c }
            if (r7 == 0) goto L_0x016f
            a.d.a.a.i.b.c5 r7 = r14.f2563a     // Catch:{ IllegalStateException -> 0x016c }
            android.content.Context r7 = r7.f2123a     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r8 = "google_app_id"
            java.lang.String r7 = a.c.a.f.b.Z0(r7, r8)     // Catch:{ IllegalStateException -> 0x016c }
            goto L_0x0177
        L_0x016c:
            r2 = move-exception
            goto L_0x021d
        L_0x016f:
            java.lang.String r7 = "getGoogleAppId"
            a.d.a.a.e.k.l.g r7 = a.d.a.a.e.k.l.g.a(r7)     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r7 = r7.f1301a     // Catch:{ IllegalStateException -> 0x016c }
        L_0x0177:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x016c }
            if (r8 == 0) goto L_0x017f
            r8 = r3
            goto L_0x0180
        L_0x017f:
            r8 = r7
        L_0x0180:
            r14.k = r8     // Catch:{ IllegalStateException -> 0x016c }
            boolean r8 = a.d.a.a.h.g.jb.b()     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r9 = "admob_app_id"
            java.lang.String r10 = "string"
            if (r8 == 0) goto L_0x01dc
            a.d.a.a.i.b.c5 r8 = r14.f2563a     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.i.b.ka r8 = r8.g     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.i.b.n3<java.lang.Boolean> r11 = a.d.a.a.i.b.q.k0     // Catch:{ IllegalStateException -> 0x016c }
            boolean r8 = r8.o(r11)     // Catch:{ IllegalStateException -> 0x016c }
            if (r8 == 0) goto L_0x01dc
            a.d.a.a.i.b.c5 r8 = r14.f2563a     // Catch:{ IllegalStateException -> 0x016c }
            android.content.Context r8 = r8.f2123a     // Catch:{ IllegalStateException -> 0x016c }
            a.c.a.f.b.k(r8)     // Catch:{ IllegalStateException -> 0x016c }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ IllegalStateException -> 0x016c }
            int r11 = a.d.a.a.e.i.common_google_play_services_unknown_issue     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r11 = r8.getResourcePackageName(r11)     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r12 = "ga_app_id"
            int r12 = r8.getIdentifier(r12, r10, r11)     // Catch:{ IllegalStateException -> 0x016c }
            if (r12 != 0) goto L_0x01b3
            r12 = r6
            goto L_0x01b7
        L_0x01b3:
            java.lang.String r12 = r8.getString(r12)     // Catch:{ IllegalStateException -> 0x016c }
        L_0x01b7:
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IllegalStateException -> 0x016c }
            if (r13 == 0) goto L_0x01be
            goto L_0x01bf
        L_0x01be:
            r3 = r12
        L_0x01bf:
            r14.m = r3     // Catch:{ IllegalStateException -> 0x016c }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x016c }
            if (r3 == 0) goto L_0x01cd
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IllegalStateException -> 0x016c }
            if (r3 != 0) goto L_0x0200
        L_0x01cd:
            int r3 = r8.getIdentifier(r9, r10, r11)     // Catch:{ IllegalStateException -> 0x016c }
            if (r3 != 0) goto L_0x01d5
            r3 = r6
            goto L_0x01d9
        L_0x01d5:
            java.lang.String r3 = r8.getString(r3)     // Catch:{ IllegalStateException -> 0x016c }
        L_0x01d9:
            r14.l = r3     // Catch:{ IllegalStateException -> 0x016c }
            goto L_0x0200
        L_0x01dc:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x016c }
            if (r3 != 0) goto L_0x0200
            a.d.a.a.i.b.c5 r3 = r14.f2563a     // Catch:{ IllegalStateException -> 0x016c }
            android.content.Context r3 = r3.f2123a     // Catch:{ IllegalStateException -> 0x016c }
            a.c.a.f.b.k(r3)     // Catch:{ IllegalStateException -> 0x016c }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ IllegalStateException -> 0x016c }
            int r7 = a.d.a.a.e.i.common_google_play_services_unknown_issue     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r7 = r3.getResourcePackageName(r7)     // Catch:{ IllegalStateException -> 0x016c }
            int r7 = r3.getIdentifier(r9, r10, r7)     // Catch:{ IllegalStateException -> 0x016c }
            if (r7 != 0) goto L_0x01fb
            r3 = r6
            goto L_0x01d9
        L_0x01fb:
            java.lang.String r3 = r3.getString(r7)     // Catch:{ IllegalStateException -> 0x016c }
            goto L_0x01d9
        L_0x0200:
            if (r2 == 0) goto L_0x022c
            a.d.a.a.i.b.x3 r2 = r14.i()     // Catch:{ IllegalStateException -> 0x016c }
            a.d.a.a.i.b.z3 r2 = r2.n     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r7 = r14.f2474c     // Catch:{ IllegalStateException -> 0x016c }
            java.lang.String r8 = r14.k     // Catch:{ IllegalStateException -> 0x016c }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x016c }
            if (r8 == 0) goto L_0x0217
            java.lang.String r8 = r14.l     // Catch:{ IllegalStateException -> 0x016c }
            goto L_0x0219
        L_0x0217:
            java.lang.String r8 = r14.k     // Catch:{ IllegalStateException -> 0x016c }
        L_0x0219:
            r2.c(r3, r7, r8)     // Catch:{ IllegalStateException -> 0x016c }
            goto L_0x022c
        L_0x021d:
            a.d.a.a.i.b.x3 r3 = r14.i()
            a.d.a.a.i.b.z3 r3 = r3.f
            java.lang.Object r0 = a.d.a.a.i.b.x3.s(r0)
            java.lang.String r7 = "Fetching Google App Id failed with exception. appId"
            r3.c(r7, r0, r2)
        L_0x022c:
            r14.i = r6
            a.d.a.a.i.b.c5 r0 = r14.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r2 = "analytics.safelisted_events"
            if (r0 == 0) goto L_0x02c8
            a.c.a.f.b.h(r2)
            android.os.Bundle r3 = r0.C()
            if (r3 != 0) goto L_0x024b
            a.d.a.a.i.b.x3 r2 = r0.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r3 = "Failed to load metadata: Metadata bundle is null"
            r2.a(r3)
            goto L_0x0251
        L_0x024b:
            boolean r7 = r3.containsKey(r2)
            if (r7 != 0) goto L_0x0253
        L_0x0251:
            r2 = r6
            goto L_0x025b
        L_0x0253:
            int r2 = r3.getInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x025b:
            if (r2 != 0) goto L_0x025e
            goto L_0x0282
        L_0x025e:
            a.d.a.a.i.b.c5 r3 = r0.f2563a     // Catch:{ NotFoundException -> 0x0276 }
            android.content.Context r3 = r3.f2123a     // Catch:{ NotFoundException -> 0x0276 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NotFoundException -> 0x0276 }
            int r2 = r2.intValue()     // Catch:{ NotFoundException -> 0x0276 }
            java.lang.String[] r2 = r3.getStringArray(r2)     // Catch:{ NotFoundException -> 0x0276 }
            if (r2 != 0) goto L_0x0271
            goto L_0x0282
        L_0x0271:
            java.util.List r6 = java.util.Arrays.asList(r2)     // Catch:{ NotFoundException -> 0x0276 }
            goto L_0x0282
        L_0x0276:
            r2 = move-exception
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r3 = "Failed to load string array from metadata: resource not found"
            r0.b(r3, r2)
        L_0x0282:
            if (r6 == 0) goto L_0x02b4
            int r0 = r6.size()
            if (r0 != 0) goto L_0x0297
            a.d.a.a.i.b.x3 r0 = r14.i()
            a.d.a.a.i.b.z3 r0 = r0.k
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.a(r2)
        L_0x0295:
            r5 = 0
            goto L_0x02b4
        L_0x0297:
            java.util.Iterator r0 = r6.iterator()
        L_0x029b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02b4
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            a.d.a.a.i.b.v9 r3 = r14.e()
            java.lang.String r7 = "safelisted event"
            boolean r2 = r3.l0(r7, r2)
            if (r2 != 0) goto L_0x029b
            goto L_0x0295
        L_0x02b4:
            if (r5 == 0) goto L_0x02b8
            r14.i = r6
        L_0x02b8:
            if (r1 == 0) goto L_0x02c5
            a.d.a.a.i.b.c5 r0 = r14.f2563a
            android.content.Context r0 = r0.f2123a
            boolean r0 = a.d.a.a.e.r.a.a(r0)
            r14.j = r0
            return
        L_0x02c5:
            r14.j = r4
            return
        L_0x02c8:
            goto L_0x02ca
        L_0x02c9:
            throw r6
        L_0x02ca:
            goto L_0x02c9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.q3.x():void");
    }
}
