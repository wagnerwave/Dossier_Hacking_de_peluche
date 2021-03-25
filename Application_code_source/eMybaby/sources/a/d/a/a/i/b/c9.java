package a.d.a.a.i.b;

import androidx.annotation.WorkerThread;

public final class c9 {

    /* renamed from: a  reason: collision with root package name */
    public f9 f2139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b9 f2140b;

    public c9(b9 b9Var) {
        this.f2140b = b9Var;
    }

    @WorkerThread
    public final void a() {
        f9 f9Var;
        this.f2140b.b();
        if (this.f2140b.f2563a.g.o(q.l0) && (f9Var = this.f2139a) != null) {
            this.f2140b.f2109c.removeCallbacks(f9Var);
        }
        if (this.f2140b.f2563a.g.o(q.x0)) {
            this.f2140b.k().w.a(false);
        }
    }
}
