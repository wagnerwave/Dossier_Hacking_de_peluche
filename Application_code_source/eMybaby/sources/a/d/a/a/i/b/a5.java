package a.d.a.a.i.b;

public abstract class a5 extends z1 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f2081b;

    public a5(c5 c5Var) {
        super(c5Var);
        this.f2563a.E++;
    }

    public final void u() {
        if (!this.f2081b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (this.f2081b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!w()) {
            this.f2563a.F.incrementAndGet();
            this.f2081b = true;
        }
    }

    public abstract boolean w();

    public void x() {
    }
}
