package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;

public final class g9 extends i {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h9 f2228e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g9(h9 h9Var, x5 x5Var) {
        super(x5Var);
        this.f2228e = h9Var;
    }

    @WorkerThread
    public final void a() {
        h9 h9Var = this.f2228e;
        h9Var.f2253d.b();
        if (((c) h9Var.f2253d.f2563a.n) != null) {
            h9Var.a(false, false, SystemClock.elapsedRealtime());
            a n = h9Var.f2253d.n();
            if (((c) h9Var.f2253d.f2563a.n) != null) {
                n.u(SystemClock.elapsedRealtime());
                return;
            }
            throw null;
        }
        throw null;
    }
}
