package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import a.d.a.a.h.g.bb;
import a.d.a.a.h.g.xa;
import a.d.a.a.h.g.ya;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;

public final class h9 {

    /* renamed from: a  reason: collision with root package name */
    public long f2250a;

    /* renamed from: b  reason: collision with root package name */
    public long f2251b;

    /* renamed from: c  reason: collision with root package name */
    public final i f2252c = new g9(this, this.f2253d.f2563a);

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b9 f2253d;

    public h9(b9 b9Var) {
        this.f2253d = b9Var;
        if (((c) b9Var.f2563a.n) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f2250a = elapsedRealtime;
            this.f2251b = elapsedRealtime;
            return;
        }
        throw null;
    }

    @WorkerThread
    public final boolean a(boolean z, boolean z2, long j) {
        this.f2253d.b();
        this.f2253d.u();
        if (!xa.b() || !this.f2253d.f2563a.g.o(q.s0) || this.f2253d.f2563a.d()) {
            o4 o4Var = this.f2253d.k().u;
            if (((c) this.f2253d.f2563a.n) != null) {
                o4Var.b(System.currentTimeMillis());
            } else {
                throw null;
            }
        }
        long j2 = j - this.f2250a;
        if (z || j2 >= 1000) {
            if (this.f2253d.f2563a.g.o(q.U) && !z2) {
                if (!((bb) ya.f2050b.a()).a() || !this.f2253d.f2563a.g.o(q.W)) {
                    j2 = b();
                } else {
                    j2 = j - this.f2251b;
                    this.f2251b = j;
                }
            }
            this.f2253d.i().n.b("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            l7.C(this.f2253d.r().y(!this.f2253d.f2563a.g.y().booleanValue()), bundle, true);
            if (this.f2253d.f2563a.g.o(q.U) && !this.f2253d.f2563a.g.o(q.V) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.f2253d.f2563a.g.o(q.V) || !z2) {
                this.f2253d.o().H("auto", "_e", bundle);
            }
            this.f2250a = j;
            this.f2252c.c();
            this.f2252c.b(3600000);
            return true;
        }
        this.f2253d.i().n.b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    @WorkerThread
    public final long b() {
        if (((c) this.f2253d.f2563a.n) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.f2251b;
            this.f2251b = elapsedRealtime;
            return j;
        }
        throw null;
    }
}
