package a.d.a.a.i.b;

import a.d.a.a.h.g.u9;
import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.Callable;

public final class r9 implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o9 f2506b;

    public r9(o9 o9Var, zzn zzn) {
        this.f2506b = o9Var;
        this.f2505a = zzn;
    }

    public final Object call() {
        if (!u9.b() || !this.f2506b.j.g.o(q.Q0) || (this.f2506b.a(this.f2505a.f4285a).k() && e.b(this.f2505a.w).k())) {
            return this.f2506b.F(this.f2505a).s();
        }
        this.f2506b.i().n.a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
