package a.d.a.a.i.b;

import a.c.a.f.b;

public abstract class m9 extends v5 implements x5 {

    /* renamed from: b  reason: collision with root package name */
    public final o9 f2386b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2387c;

    public m9(o9 o9Var) {
        super(o9Var.j);
        b.k(o9Var);
        this.f2386b = o9Var;
        o9Var.o++;
    }

    public s9 l() {
        return this.f2386b.M();
    }

    public final void n() {
        if (!this.f2387c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o() {
        if (!this.f2387c) {
            p();
            this.f2386b.p++;
            this.f2387c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean p();

    public d q() {
        return this.f2386b.J();
    }

    public w4 r() {
        return this.f2386b.G();
    }
}
