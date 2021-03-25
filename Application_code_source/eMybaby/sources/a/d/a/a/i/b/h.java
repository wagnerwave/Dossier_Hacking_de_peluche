package a.d.a.a.i.b;

public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x5 f2233a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f2234b;

    public h(i iVar, x5 x5Var) {
        this.f2234b = iVar;
        this.f2233a = x5Var;
    }

    public final void run() {
        this.f2233a.m();
        if (ja.a()) {
            this.f2233a.f().v(this);
            return;
        }
        boolean z = this.f2234b.f2257c != 0;
        this.f2234b.f2257c = 0;
        if (z) {
            this.f2234b.a();
        }
    }
}
