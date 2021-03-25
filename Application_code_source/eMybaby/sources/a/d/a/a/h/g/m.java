package a.d.a.a.h.g;

import a.d.a.a.h.g.f;

public final class m extends f.a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Boolean f1816e;
    public final /* synthetic */ f f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(f fVar, Boolean bool) {
        super(true);
        this.f = fVar;
        this.f1816e = bool;
    }

    public final void a() {
        Boolean bool = this.f1816e;
        if (bool != null) {
            this.f.h.setMeasurementEnabled(bool.booleanValue(), this.f1686a);
        } else {
            this.f.h.clearMeasurementEnabled(this.f1686a);
        }
    }
}
