package a.d.a.a.h.f;

public abstract class f extends e {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1492b;

    public f(h hVar) {
        super(hVar);
    }

    public final boolean r() {
        return this.f1492b;
    }

    public final void s() {
        t();
        this.f1492b = true;
    }

    public abstract void t();

    public final void u() {
        if (!r()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
