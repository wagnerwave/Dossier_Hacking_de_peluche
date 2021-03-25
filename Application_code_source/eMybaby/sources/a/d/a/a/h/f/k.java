package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.b.f;
import a.d.a.a.e.p.a;
import android.content.Context;
import android.os.RemoteException;
import java.util.Collections;

public final class k extends f {

    /* renamed from: c  reason: collision with root package name */
    public final m f1518c = new m(this);

    /* renamed from: d  reason: collision with root package name */
    public o0 f1519d;

    /* renamed from: e  reason: collision with root package name */
    public final d0 f1520e;
    public final d1 f;

    public k(h hVar) {
        super(hVar);
        this.f = new d1(hVar.f1505c);
        this.f1520e = new l(this, hVar);
    }

    public final void t() {
    }

    public final void v() {
        f.b();
        u();
        try {
            a a2 = a.a();
            Context context = this.f1490a.f1503a;
            m mVar = this.f1518c;
            if (a2 != null) {
                context.unbindService(mVar);
                if (this.f1519d != null) {
                    this.f1519d = null;
                    b i = i();
                    i.u();
                    f.b();
                    s sVar = i.f1473c;
                    f.b();
                    sVar.u();
                    sVar.o("Service disconnected");
                    return;
                }
                return;
            }
            throw null;
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
    }

    public final boolean w() {
        f.b();
        u();
        return this.f1519d != null;
    }

    public final boolean x(n0 n0Var) {
        b.k(n0Var);
        f.b();
        u();
        o0 o0Var = this.f1519d;
        if (o0Var == null) {
            return false;
        }
        try {
            o0Var.C(n0Var.f1538a, n0Var.f1540c, n0Var.f1542e ? b0.d() : b0.e(), Collections.emptyList());
            y();
            return true;
        } catch (RemoteException unused) {
            o("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void y() {
        this.f.a();
        this.f1520e.e(((Long) i0.x.f1517a).longValue());
    }
}
