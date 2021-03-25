package a.d.a.a.i.b;

import a.d.a.a.e.g;
import a.d.a.a.e.m.b;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;

public final class u3 extends b<p3> {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u3(android.content.Context r10, android.os.Looper r11, a.d.a.a.e.m.b.a r12, a.d.a.a.e.m.b.C0060b r13) {
        /*
            r9 = this;
            a.d.a.a.e.m.g r3 = a.d.a.a.e.m.g.a(r10)
            a.d.a.a.e.d r4 = a.d.a.a.e.d.f1239b
            a.c.a.f.b.k(r12)
            a.c.a.f.b.k(r13)
            r5 = 93
            r8 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.u3.<init>(android.content.Context, android.os.Looper, a.d.a.a.e.m.b$a, a.d.a.a.e.m.b$b):void");
    }

    public final int f() {
        return g.f1241a;
    }

    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof p3 ? (p3) queryLocalInterface : new r3(iBinder);
    }

    @NonNull
    public final String q() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @NonNull
    public final String r() {
        return "com.google.android.gms.measurement.START";
    }
}
