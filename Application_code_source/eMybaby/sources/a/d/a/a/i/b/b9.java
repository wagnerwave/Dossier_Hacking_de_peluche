package a.d.a.a.i.b;

import a.d.a.a.h.g.kd;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;

public final class b9 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public Handler f2109c;

    /* renamed from: d  reason: collision with root package name */
    public final j9 f2110d = new j9(this);

    /* renamed from: e  reason: collision with root package name */
    public final h9 f2111e = new h9(this);
    public final c9 f = new c9(this);

    public b9(c5 c5Var) {
        super(c5Var);
    }

    public final boolean w() {
        return false;
    }

    public final boolean y(boolean z, boolean z2, long j) {
        return this.f2111e.a(z, z2, j);
    }

    @WorkerThread
    public final void z() {
        b();
        if (this.f2109c == null) {
            this.f2109c = new kd(Looper.getMainLooper());
        }
    }
}
