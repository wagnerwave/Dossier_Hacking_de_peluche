package a.d.a.a.i.b;

import a.c.a.f.b;

public final class n8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p3 f2415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o8 f2416b;

    public n8(o8 o8Var, p3 p3Var) {
        this.f2416b = o8Var;
        this.f2415a = p3Var;
    }

    public final void run() {
        synchronized (this.f2416b) {
            this.f2416b.f2439a = false;
            if (!this.f2416b.f2441c.D()) {
                this.f2416b.f2441c.i().n.a("Connected to service");
                u7 u7Var = this.f2416b.f2441c;
                p3 p3Var = this.f2415a;
                u7Var.b();
                b.k(p3Var);
                u7Var.f2549d = p3Var;
                u7Var.H();
                u7Var.J();
            }
        }
    }
}
