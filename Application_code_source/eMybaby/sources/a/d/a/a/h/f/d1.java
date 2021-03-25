package a.d.a.a.h.f;

import a.d.a.a.e.q.b;
import a.d.a.a.e.q.c;
import android.os.SystemClock;

public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    public final b f1488a;

    /* renamed from: b  reason: collision with root package name */
    public long f1489b;

    public d1(b bVar) {
        a.c.a.f.b.k(bVar);
        this.f1488a = bVar;
    }

    public final void a() {
        if (((c) this.f1488a) != null) {
            this.f1489b = SystemClock.elapsedRealtime();
            return;
        }
        throw null;
    }

    public final boolean b(long j) {
        if (this.f1489b == 0) {
            return true;
        }
        if (((c) this.f1488a) == null) {
            throw null;
        } else if (SystemClock.elapsedRealtime() - this.f1489b > j) {
            return true;
        } else {
            return false;
        }
    }
}
