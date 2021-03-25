package a.d.a.a.h.f;

import a.d.a.a.b.f;

public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o0 f1536a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1537b;

    public n(m mVar, o0 o0Var) {
        this.f1537b = mVar;
        this.f1536a = o0Var;
    }

    public final void run() {
        if (!this.f1537b.f1530c.w()) {
            this.f1537b.f1530c.a(3, "Connected to service after a timeout", (Object) null, (Object) null, (Object) null);
            k kVar = this.f1537b.f1530c;
            o0 o0Var = this.f1536a;
            if (kVar != null) {
                f.b();
                kVar.f1519d = o0Var;
                kVar.y();
                b i = kVar.i();
                if (i != null) {
                    f.b();
                    i.f1473c.v();
                    return;
                }
                throw null;
            }
            throw null;
        }
    }
}
