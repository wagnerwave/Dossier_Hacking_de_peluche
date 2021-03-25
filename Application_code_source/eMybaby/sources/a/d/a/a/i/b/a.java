package a.d.a.a.i.b;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Map;

public final class a extends z1 {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Long> f2068b = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Integer> f2069c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    public long f2070d;

    public a(c5 c5Var) {
        super(c5Var);
    }

    @WorkerThread
    public final void u(long j) {
        m7 y = r().y(false);
        for (String next : this.f2068b.keySet()) {
            x(next, j - this.f2068b.get(next).longValue(), y);
        }
        if (!this.f2068b.isEmpty()) {
            v(j - this.f2070d, y);
        }
        y(j);
    }

    @WorkerThread
    public final void v(long j, m7 m7Var) {
        if (m7Var == null) {
            i().n.a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            i().n.b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            l7.C(m7Var, bundle, true);
            o().H("am", "_xa", bundle);
        }
    }

    public final void w(String str, long j) {
        if (str == null || str.length() == 0) {
            i().f.a("Ad unit id must be a non-empty string");
        } else {
            f().v(new y0(this, str, j));
        }
    }

    @WorkerThread
    public final void x(String str, long j, m7 m7Var) {
        if (m7Var == null) {
            i().n.a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            i().n.b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            l7.C(m7Var, bundle, true);
            o().H("am", "_xu", bundle);
        }
    }

    @WorkerThread
    public final void y(long j) {
        for (String put : this.f2068b.keySet()) {
            this.f2068b.put(put, Long.valueOf(j));
        }
        if (!this.f2068b.isEmpty()) {
            this.f2070d = j;
        }
    }

    public final void z(String str, long j) {
        if (str == null || str.length() == 0) {
            i().f.a("Ad unit id must be a non-empty string");
        } else {
            f().v(new x(this, str, j));
        }
    }
}
