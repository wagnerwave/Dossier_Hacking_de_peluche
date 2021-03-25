package a.d.a.a.e.k.l;

import a.d.a.a.e.k.a;
import a.d.a.a.e.k.i;
import a.d.a.a.e.k.l.d;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public final class i0<A extends d<? extends i, a.b>> extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final A f1305a;

    public i0(int i, A a2) {
        super(i);
        this.f1305a = a2;
    }

    public final void a(@NonNull Status status) {
        this.f1305a.j(status);
    }

    public final void b(@NonNull r0 r0Var, boolean z) {
        A a2 = this.f1305a;
        r0Var.f1322a.put(a2, Boolean.valueOf(z));
        a2.a(new m(r0Var, a2));
    }

    public final void c(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        this.f1305a.j(new Status(10, a.a.a.a.a.d(String.valueOf(localizedMessage).length() + simpleName.length() + 2, simpleName, ": ", localizedMessage)));
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(a.d.a.a.e.k.l.f.a<?> r7) {
        /*
            r6 = this;
            A r0 = r6.f1305a     // Catch:{ RuntimeException -> 0x0036 }
            a.d.a.a.e.k.a$f r7 = r7.f1286b     // Catch:{ RuntimeException -> 0x0036 }
            r1 = 0
            if (r0 == 0) goto L_0x0035
            boolean r2 = r7 instanceof a.d.a.a.e.m.s     // Catch:{ RuntimeException -> 0x0036 }
            if (r2 == 0) goto L_0x0012
            a.d.a.a.e.m.s r7 = (a.d.a.a.e.m.s) r7     // Catch:{ RuntimeException -> 0x0036 }
            if (r7 == 0) goto L_0x0011
            r7 = r1
            goto L_0x0012
        L_0x0011:
            throw r1     // Catch:{ RuntimeException -> 0x0036 }
        L_0x0012:
            r2 = 8
            r3 = 1
            r0.i(r7)     // Catch:{ DeadObjectException -> 0x0027, RemoteException -> 0x0019 }
            goto L_0x0026
        L_0x0019:
            r7 = move-exception
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status     // Catch:{ RuntimeException -> 0x0036 }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ RuntimeException -> 0x0036 }
            r4.<init>(r3, r2, r7, r1)     // Catch:{ RuntimeException -> 0x0036 }
            r0.j(r4)     // Catch:{ RuntimeException -> 0x0036 }
        L_0x0026:
            return
        L_0x0027:
            r7 = move-exception
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status     // Catch:{ RuntimeException -> 0x0036 }
            java.lang.String r5 = r7.getLocalizedMessage()     // Catch:{ RuntimeException -> 0x0036 }
            r4.<init>(r3, r2, r5, r1)     // Catch:{ RuntimeException -> 0x0036 }
            r0.j(r4)     // Catch:{ RuntimeException -> 0x0036 }
            throw r7     // Catch:{ RuntimeException -> 0x0036 }
        L_0x0035:
            throw r1     // Catch:{ RuntimeException -> 0x0036 }
        L_0x0036:
            r7 = move-exception
            r6.c(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.k.l.i0.e(a.d.a.a.e.k.l.f$a):void");
    }
}
