package a.d.a.a.h.g;

import a.d.a.a.h.g.f;
import android.content.Context;
import android.os.Bundle;

public final class i extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1731e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ Bundle h;
    public final /* synthetic */ f i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(f fVar, String str, String str2, Context context, Bundle bundle) {
        super(true);
        this.i = fVar;
        this.f1731e = str;
        this.f = str2;
        this.g = context;
        this.h = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad A[Catch:{ Exception -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            a.d.a.a.h.g.f r2 = r14.i     // Catch:{ Exception -> 0x00ae }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ae }
            r3.<init>()     // Catch:{ Exception -> 0x00ae }
            r2.f1685e = r3     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = r14.f1731e     // Catch:{ Exception -> 0x00ae }
            java.lang.String r3 = r14.f     // Catch:{ Exception -> 0x00ae }
            boolean r2 = a.d.a.a.h.g.f.e(r2, r3)     // Catch:{ Exception -> 0x00ae }
            r3 = 0
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = r14.f     // Catch:{ Exception -> 0x00ae }
            java.lang.String r4 = r14.f1731e     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.f r5 = r14.i     // Catch:{ Exception -> 0x00ae }
            java.lang.String r5 = r5.f1681a     // Catch:{ Exception -> 0x00ae }
            r11 = r2
            r10 = r4
            r9 = r5
            goto L_0x0025
        L_0x0022:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x0025:
            android.content.Context r2 = r14.g     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.f.d(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.Boolean r2 = a.d.a.a.h.g.f.j     // Catch:{ Exception -> 0x00ae }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x00ae }
            if (r2 != 0) goto L_0x0037
            if (r10 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = 0
            goto L_0x0038
        L_0x0037:
            r2 = 1
        L_0x0038:
            a.d.a.a.h.g.f r4 = r14.i     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.f r5 = r14.i     // Catch:{ Exception -> 0x00ae }
            android.content.Context r6 = r14.g     // Catch:{ Exception -> 0x00ae }
            if (r5 == 0) goto L_0x00ad
            java.lang.String r7 = "com.google.android.gms.measurement.dynamite"
            if (r2 == 0) goto L_0x0047
            com.google.android.gms.dynamite.DynamiteModule$b r8 = com.google.android.gms.dynamite.DynamiteModule.k     // Catch:{ a -> 0x0058 }
            goto L_0x0049
        L_0x0047:
            com.google.android.gms.dynamite.DynamiteModule$b r8 = com.google.android.gms.dynamite.DynamiteModule.i     // Catch:{ a -> 0x0058 }
        L_0x0049:
            com.google.android.gms.dynamite.DynamiteModule r6 = com.google.android.gms.dynamite.DynamiteModule.c(r6, r8, r7)     // Catch:{ a -> 0x0058 }
            java.lang.String r8 = "com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"
            android.os.IBinder r6 = r6.b(r8)     // Catch:{ a -> 0x0058 }
            a.d.a.a.h.g.nd r3 = a.d.a.a.h.g.md.asInterface(r6)     // Catch:{ a -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            r5.b(r6, r1, r0)     // Catch:{ Exception -> 0x00ae }
        L_0x005c:
            r4.h = r3     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.f r3 = r14.i     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.nd r3 = r3.h     // Catch:{ Exception -> 0x00ae }
            if (r3 != 0) goto L_0x006e
            a.d.a.a.h.g.f r2 = r14.i     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = r2.f1681a     // Catch:{ Exception -> 0x00ae }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x00ae }
            return
        L_0x006e:
            android.content.Context r3 = r14.g     // Catch:{ Exception -> 0x00ae }
            int r3 = com.google.android.gms.dynamite.DynamiteModule.a(r3, r7)     // Catch:{ Exception -> 0x00ae }
            android.content.Context r4 = r14.g     // Catch:{ Exception -> 0x00ae }
            int r4 = com.google.android.gms.dynamite.DynamiteModule.d(r4, r7, r0)     // Catch:{ Exception -> 0x00ae }
            if (r2 == 0) goto L_0x0087
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x00ae }
            if (r4 >= r3) goto L_0x0084
            r3 = 1
            goto L_0x0085
        L_0x0084:
            r3 = 0
        L_0x0085:
            r8 = r3
            goto L_0x0091
        L_0x0087:
            if (r3 <= 0) goto L_0x008a
            r4 = r3
        L_0x008a:
            if (r3 <= 0) goto L_0x008e
            r2 = 1
            goto L_0x008f
        L_0x008e:
            r2 = 0
        L_0x008f:
            r8 = r2
            r2 = r4
        L_0x0091:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ Exception -> 0x00ae }
            r4 = 31049(0x7949, double:1.534E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x00ae }
            android.os.Bundle r12 = r14.h     // Catch:{ Exception -> 0x00ae }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.f r2 = r14.i     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.h.g.nd r2 = r2.h     // Catch:{ Exception -> 0x00ae }
            android.content.Context r3 = r14.g     // Catch:{ Exception -> 0x00ae }
            a.d.a.a.f.b r4 = new a.d.a.a.f.b     // Catch:{ Exception -> 0x00ae }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00ae }
            long r5 = r14.f1686a     // Catch:{ Exception -> 0x00ae }
            r2.initialize(r4, r13, r5)     // Catch:{ Exception -> 0x00ae }
            return
        L_0x00ad:
            throw r3     // Catch:{ Exception -> 0x00ae }
        L_0x00ae:
            r2 = move-exception
            a.d.a.a.h.g.f r3 = r14.i
            r3.b(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.i.a():void");
    }
}
