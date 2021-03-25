package a.d.a.a.i.b;

import a.d.a.a.h.g.a2;
import android.content.ServiceConnection;

public final class r4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a2 f2495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f2496b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s4 f2497c;

    public r4(s4 s4Var, a2 a2Var, ServiceConnection serviceConnection) {
        this.f2497c = s4Var;
        this.f2495a = a2Var;
        this.f2496b = serviceConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            a.d.a.a.i.b.s4 r0 = r14.f2497c
            a.d.a.a.i.b.p4 r1 = r0.f2513b
            java.lang.String r0 = r0.f2512a
            a.d.a.a.h.g.a2 r2 = r14.f2495a
            android.content.ServiceConnection r3 = r14.f2496b
            a.d.a.a.i.b.c5 r4 = r1.f2455a
            a.d.a.a.i.b.v4 r4 = r4.f()
            r4.b()
            r4 = 0
            if (r2 != 0) goto L_0x0024
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r2 = "Attempting to use Install Referrer Service while it is not initialized"
            r0.a(r2)
            goto L_0x0054
        L_0x0024:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "package_name"
            r5.putString(r6, r0)
            android.os.Bundle r0 = r2.f(r5)     // Catch:{ Exception -> 0x0042 }
            if (r0 != 0) goto L_0x0055
            a.d.a.a.i.b.c5 r0 = r1.f2455a     // Catch:{ Exception -> 0x0042 }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ Exception -> 0x0042 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = "Install Referrer Service returned a null response"
            r0.a(r2)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0054
        L_0x0042:
            r0 = move-exception
            a.d.a.a.i.b.c5 r2 = r1.f2455a
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "Exception occurred while retrieving the Install Referrer"
            r2.b(r5, r0)
        L_0x0054:
            r0 = r4
        L_0x0055:
            a.d.a.a.i.b.c5 r2 = r1.f2455a
            a.d.a.a.i.b.v4 r2 = r2.f()
            r2.b()
            if (r0 == 0) goto L_0x0178
            r5 = 0
            java.lang.String r2 = "install_begin_timestamp_seconds"
            long r7 = r0.getLong(r2, r5)
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x007c
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.i
            java.lang.String r2 = "Service response is missing Install Referrer install timestamp"
            goto L_0x0175
        L_0x007c:
            java.lang.String r2 = "install_referrer"
            java.lang.String r2 = r0.getString(r2)
            if (r2 == 0) goto L_0x016b
            boolean r11 = r2.isEmpty()
            if (r11 == 0) goto L_0x008c
            goto L_0x016b
        L_0x008c:
            a.d.a.a.i.b.c5 r11 = r1.f2455a
            a.d.a.a.i.b.x3 r11 = r11.i()
            a.d.a.a.i.b.z3 r11 = r11.n
            java.lang.String r12 = "InstallReferrer API result"
            r11.b(r12, r2)
            a.d.a.a.i.b.c5 r11 = r1.f2455a
            a.d.a.a.i.b.v9 r11 = r11.t()
            java.lang.String r12 = "?"
            int r13 = r2.length()
            if (r13 == 0) goto L_0x00ac
            java.lang.String r2 = r12.concat(r2)
            goto L_0x00b1
        L_0x00ac:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r12)
        L_0x00b1:
            android.net.Uri r2 = android.net.Uri.parse(r2)
            android.os.Bundle r2 = r11.x(r2)
            if (r2 != 0) goto L_0x00c7
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r2 = "No campaign params defined in Install Referrer result"
            goto L_0x0175
        L_0x00c7:
            java.lang.String r11 = "medium"
            java.lang.String r11 = r2.getString(r11)
            if (r11 == 0) goto L_0x00e1
            java.lang.String r12 = "(not set)"
            boolean r12 = r12.equalsIgnoreCase(r11)
            if (r12 != 0) goto L_0x00e1
            java.lang.String r12 = "organic"
            boolean r11 = r12.equalsIgnoreCase(r11)
            if (r11 != 0) goto L_0x00e1
            r11 = 1
            goto L_0x00e2
        L_0x00e1:
            r11 = 0
        L_0x00e2:
            if (r11 == 0) goto L_0x0101
            java.lang.String r11 = "referrer_click_timestamp_seconds"
            long r11 = r0.getLong(r11, r5)
            long r11 = r11 * r9
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00fc
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r2 = "Install Referrer is missing click timestamp for ad campaign"
            goto L_0x0175
        L_0x00fc:
            java.lang.String r0 = "click_timestamp"
            r2.putLong(r0, r11)
        L_0x0101:
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.k4 r0 = r0.o()
            a.d.a.a.i.b.o4 r0 = r0.k
            long r5 = r0.a()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x011c
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r2 = "Install Referrer campaign has already been logged"
            goto L_0x0175
        L_0x011c:
            a.d.a.a.h.g.ma r0 = a.d.a.a.h.g.ma.f1835b
            java.lang.Object r0 = r0.a()
            a.d.a.a.h.g.pa r0 = (a.d.a.a.h.g.pa) r0
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x013e
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.ka r0 = r0.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.v0
            boolean r0 = r0.o(r5)
            if (r0 == 0) goto L_0x013e
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0178
        L_0x013e:
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.k4 r0 = r0.o()
            a.d.a.a.i.b.o4 r0 = r0.k
            r0.b(r7)
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r5 = "referrer API"
            java.lang.String r6 = "Logging Install Referrer campaign from sdk with "
            r0.b(r6, r5)
            java.lang.String r0 = "_cis"
            r2.putString(r0, r5)
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.f6 r0 = r0.s()
            java.lang.String r5 = "auto"
            java.lang.String r6 = "_cmp"
            r0.H(r5, r6, r2)
            goto L_0x0178
        L_0x016b:
            a.d.a.a.i.b.c5 r0 = r1.f2455a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r2 = "No referrer defined in Install Referrer response"
        L_0x0175:
            r0.a(r2)
        L_0x0178:
            if (r3 == 0) goto L_0x0189
            a.d.a.a.e.p.a r0 = a.d.a.a.e.p.a.a()
            a.d.a.a.i.b.c5 r1 = r1.f2455a
            android.content.Context r1 = r1.f2123a
            if (r0 == 0) goto L_0x0188
            r1.unbindService(r3)
            goto L_0x0189
        L_0x0188:
            throw r4
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.r4.run():void");
    }
}
