package a.d.a.a.h.g;

import a.d.a.a.h.g.i5;

public final class k5 implements d9 {

    /* renamed from: a  reason: collision with root package name */
    public final i5 f1770a;

    public k5(i5 i5Var) {
        a6.f(i5Var, "output");
        this.f1770a = i5Var;
        i5Var.f1738a = this;
    }

    public final void a(int i, double d2) {
        i5 i5Var = this.f1770a;
        if (i5Var != null) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
            i5.b bVar = (i5.b) i5Var;
            bVar.o((i << 3) | 1);
            bVar.x(doubleToRawLongBits);
            return;
        }
        throw null;
    }

    public final void b(int i, float f) {
        i5 i5Var = this.f1770a;
        if (i5Var != null) {
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            i5.b bVar = (i5.b) i5Var;
            bVar.o((i << 3) | 5);
            bVar.z(floatToRawIntBits);
            return;
        }
        throw null;
    }

    public final void c(int i, int i2) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 5);
        bVar.z(i2);
    }

    public final void d(int i, long j) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 0);
        bVar.g(j);
    }

    public final void e(int i, w4 w4Var) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 2);
        bVar.Y(w4Var);
    }

    public final void f(int i, Object obj) {
        if (obj instanceof w4) {
            i5.b bVar = (i5.b) this.f1770a;
            bVar.W(1, 3);
            bVar.b0(2, i);
            bVar.X(3, (w4) obj);
            bVar.W(1, 4);
            return;
        }
        i5.b bVar2 = (i5.b) this.f1770a;
        bVar2.W(1, 3);
        bVar2.b0(2, i);
        bVar2.W(3, 2);
        bVar2.Z((i7) obj);
        bVar2.W(1, 4);
    }

    public final void g(int i, Object obj, v7 v7Var) {
        i7 i7Var = (i7) obj;
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 2);
        o4 o4Var = (o4) i7Var;
        y5 y5Var = (y5) o4Var;
        int i2 = y5Var.zzc;
        if (i2 == -1) {
            i2 = v7Var.f(o4Var);
            y5Var.zzc = i2;
        }
        bVar.o(i2);
        v7Var.h(i7Var, bVar.f1738a);
    }

    public final void h(int i, boolean z) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 0);
        bVar.e(z ? (byte) 1 : 0);
    }

    public final void i(int i, long j) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 1);
        bVar.x(j);
    }

    public final void j(int i, Object obj, v7 v7Var) {
        i5 i5Var = this.f1770a;
        int i2 = i << 3;
        ((i5.b) i5Var).o(i2 | 3);
        v7Var.h((i7) obj, i5Var.f1738a);
        ((i5.b) i5Var).o(i2 | 4);
    }

    public final void k(int i, long j) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 0);
        bVar.g(j);
    }

    public final void l(int i, int i2) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 5);
        bVar.z(i2);
    }

    public final void m(int i, long j) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 1);
        bVar.x(j);
    }

    public final void n(int i, int i2) {
        i5.b bVar = (i5.b) this.f1770a;
        bVar.o((i << 3) | 0);
        bVar.o(i2);
    }

    public final void o(int i, long j) {
        i5 i5Var = this.f1770a;
        if (i5Var != null) {
            long Q = i5.Q(j);
            i5.b bVar = (i5.b) i5Var;
            bVar.o((i << 3) | 0);
            bVar.g(Q);
            return;
        }
        throw null;
    }

    public final void p(int i, int i2) {
        i5 i5Var = this.f1770a;
        if (i5Var != null) {
            int V = i5.V(i2);
            i5.b bVar = (i5.b) i5Var;
            bVar.o((i << 3) | 0);
            bVar.o(V);
            return;
        }
        throw null;
    }
}
