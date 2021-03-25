package a.d.a.a.i.b;

import a.d.a.a.e.q.c;

public final class n9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t9 f2417a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o9 f2418b;

    public n9(o9 o9Var, t9 t9Var) {
        this.f2418b = o9Var;
        this.f2417a = t9Var;
    }

    public final void run() {
        o9 o9Var = this.f2418b;
        o9Var.j.f().b();
        d dVar = new d(o9Var);
        dVar.o();
        o9Var.f2444c = dVar;
        o9Var.j.g.f2331c = o9Var.f2442a;
        u8 u8Var = new u8(o9Var);
        u8Var.o();
        o9Var.i = u8Var;
        ba baVar = new ba(o9Var);
        baVar.o();
        o9Var.f = baVar;
        k7 k7Var = new k7(o9Var);
        k7Var.o();
        o9Var.h = k7Var;
        l9 l9Var = new l9(o9Var);
        l9Var.o();
        o9Var.f2446e = l9Var;
        o9Var.f2445d = new i4(o9Var);
        if (o9Var.o != o9Var.p) {
            o9Var.j.i().f.c("Not all upload components initialized", Integer.valueOf(o9Var.o), Integer.valueOf(o9Var.p));
        }
        o9Var.k = true;
        o9 o9Var2 = this.f2418b;
        o9Var2.j.f().b();
        o9Var2.J().i0();
        if (o9Var2.j.o().f2317e.a() == 0) {
            o4 o4Var = o9Var2.j.o().f2317e;
            if (((c) o9Var2.j.n) != null) {
                o4Var.b(System.currentTimeMillis());
            } else {
                throw null;
            }
        }
        o9Var2.v();
    }
}
