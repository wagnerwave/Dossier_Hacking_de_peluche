package a.d.a.a.e.m;

import a.d.a.a.e.d;
import a.d.a.a.e.k.a;
import android.accounts.Account;
import android.os.IInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

public abstract class f<T extends IInterface> extends b<T> implements a.f {
    public final c w;
    public final Set<Scope> x;
    public final Account y;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r10, android.os.Looper r11, int r12, a.d.a.a.e.m.c r13, a.d.a.a.e.k.d.a r14, a.d.a.a.e.k.d.b r15) {
        /*
            r9 = this;
            a.d.a.a.e.m.g r3 = a.d.a.a.e.m.g.a(r10)
            a.d.a.a.e.c r4 = a.d.a.a.e.c.f1231d
            a.c.a.f.b.k(r14)
            a.c.a.f.b.k(r15)
            a.d.a.a.e.m.w r6 = new a.d.a.a.e.m.w
            r6.<init>(r14)
            a.d.a.a.e.m.x r7 = new a.d.a.a.e.m.x
            r7.<init>(r15)
            java.lang.String r8 = r13.f
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.w = r13
            android.accounts.Account r10 = r13.f1371a
            r9.y = r10
            java.util.Set<com.google.android.gms.common.api.Scope> r10 = r13.f1373c
            java.util.Iterator r11 = r10.iterator()
        L_0x002b:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0046
            java.lang.Object r12 = r11.next()
            com.google.android.gms.common.api.Scope r12 = (com.google.android.gms.common.api.Scope) r12
            boolean r12 = r10.contains(r12)
            if (r12 == 0) goto L_0x003e
            goto L_0x002b
        L_0x003e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Expanding scopes is not permitted, use implied scopes instead"
            r10.<init>(r11)
            throw r10
        L_0x0046:
            r9.x = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.m.f.<init>(android.content.Context, android.os.Looper, int, a.d.a.a.e.m.c, a.d.a.a.e.k.d$a, a.d.a.a.e.k.d$b):void");
    }

    @NonNull
    public Set<Scope> b() {
        return j() ? this.x : Collections.emptySet();
    }

    public int f() {
        return d.f1238a;
    }

    public final Account m() {
        return this.y;
    }

    public final Set<Scope> o() {
        return this.x;
    }
}
