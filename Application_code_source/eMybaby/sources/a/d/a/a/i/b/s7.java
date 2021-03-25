package a.d.a.a.i.b;

public final class s7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m7 f2519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f2520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l7 f2521c;

    public s7(l7 l7Var, m7 m7Var, long j) {
        this.f2521c = l7Var;
        this.f2519a = m7Var;
        this.f2520b = j;
    }

    public final void run() {
        this.f2521c.E(this.f2519a, false, this.f2520b);
        l7 l7Var = this.f2521c;
        l7Var.f2354e = null;
        u7 q = l7Var.q();
        q.b();
        q.u();
        q.B(new b8(q, (m7) null));
    }
}
