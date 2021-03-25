package a.d.a.a.h.f;

import a.d.a.a.b.f;

public final class l extends d0 {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f1525e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(k kVar, h hVar) {
        super(hVar);
        this.f1525e = kVar;
    }

    public final void c() {
        k kVar = this.f1525e;
        if (kVar != null) {
            f.b();
            if (kVar.w()) {
                kVar.o("Inactivity, disconnecting from device AnalyticsService");
                kVar.v();
                return;
            }
            return;
        }
        throw null;
    }
}
