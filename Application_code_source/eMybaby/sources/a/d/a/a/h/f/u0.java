package a.d.a.a.h.f;

import a.d.a.a.b.f;
import a.d.a.a.e.q.c;
import android.content.SharedPreferences;

public final class u0 extends f {

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f1566c;

    /* renamed from: d  reason: collision with root package name */
    public long f1567d;

    /* renamed from: e  reason: collision with root package name */
    public long f1568e = -1;
    public final w0 f = new w0(this, "monitoring", ((Long) i0.A.f1517a).longValue(), (v0) null);

    public u0(h hVar) {
        super(hVar);
    }

    public final void t() {
        this.f1566c = this.f1490a.f1503a.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long v() {
        f.b();
        u();
        if (this.f1568e == -1) {
            this.f1568e = this.f1566c.getLong("last_dispatch", 0);
        }
        return this.f1568e;
    }

    public final void w() {
        f.b();
        u();
        if (((c) this.f1490a.f1505c) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor edit = this.f1566c.edit();
            edit.putLong("last_dispatch", currentTimeMillis);
            edit.apply();
            this.f1568e = currentTimeMillis;
            return;
        }
        throw null;
    }
}
