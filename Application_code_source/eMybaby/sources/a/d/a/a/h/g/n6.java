package a.d.a.a.h.g;

public class n6 {

    /* renamed from: a  reason: collision with root package name */
    public volatile i7 f1844a;

    /* renamed from: b  reason: collision with root package name */
    public volatile w4 f1845b;

    static {
        l5.a();
    }

    public final int a() {
        if (this.f1845b != null) {
            return this.f1845b.d();
        }
        if (this.f1844a != null) {
            return this.f1844a.c();
        }
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.h.g.i7 b(a.d.a.a.h.g.i7 r2) {
        /*
            r1 = this;
            a.d.a.a.h.g.i7 r0 = r1.f1844a
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            a.d.a.a.h.g.i7 r0 = r1.f1844a     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.f1844a = r2     // Catch:{ i6 -> 0x0012 }
            a.d.a.a.h.g.w4 r0 = a.d.a.a.h.g.w4.f2000b     // Catch:{ i6 -> 0x0012 }
            r1.f1845b = r0     // Catch:{ i6 -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.f1844a = r2     // Catch:{ all -> 0x0019 }
            a.d.a.a.h.g.w4 r2 = a.d.a.a.h.g.w4.f2000b     // Catch:{ all -> 0x0019 }
            r1.f1845b = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            a.d.a.a.h.g.i7 r2 = r1.f1844a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.n6.b(a.d.a.a.h.g.i7):a.d.a.a.h.g.i7");
    }

    public final w4 c() {
        if (this.f1845b != null) {
            return this.f1845b;
        }
        synchronized (this) {
            if (this.f1845b != null) {
                w4 w4Var = this.f1845b;
                return w4Var;
            }
            this.f1845b = this.f1844a == null ? w4.f2000b : this.f1844a.b();
            w4 w4Var2 = this.f1845b;
            return w4Var2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n6)) {
            return false;
        }
        n6 n6Var = (n6) obj;
        i7 i7Var = this.f1844a;
        i7 i7Var2 = n6Var.f1844a;
        return (i7Var == null && i7Var2 == null) ? c().equals(n6Var.c()) : (i7Var == null || i7Var2 == null) ? i7Var != null ? i7Var.equals(n6Var.b(i7Var.h())) : b(i7Var2.h()).equals(i7Var2) : i7Var.equals(i7Var2);
    }

    public int hashCode() {
        return 1;
    }
}
