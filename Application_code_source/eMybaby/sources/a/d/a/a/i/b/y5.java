package a.d.a.a.i.b;

public abstract class y5 extends v5 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f2638b;

    public y5(c5 c5Var) {
        super(c5Var);
        this.f2563a.E++;
    }

    public void l() {
    }

    public final void n() {
        if (!r()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o() {
        if (this.f2638b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!q()) {
            this.f2563a.F.incrementAndGet();
            this.f2638b = true;
        }
    }

    public final void p() {
        if (!this.f2638b) {
            l();
            this.f2563a.F.incrementAndGet();
            this.f2638b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean q();

    public final boolean r() {
        return this.f2638b;
    }
}
