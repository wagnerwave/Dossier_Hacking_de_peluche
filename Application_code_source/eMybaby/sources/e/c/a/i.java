package e.c.a;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public h f5387a;

    /* renamed from: b  reason: collision with root package name */
    public h f5388b;

    public synchronized h a() {
        h hVar;
        hVar = this.f5387a;
        if (this.f5387a != null) {
            h hVar2 = this.f5387a.f5386c;
            this.f5387a = hVar2;
            if (hVar2 == null) {
                this.f5388b = null;
            }
        }
        return hVar;
    }
}
