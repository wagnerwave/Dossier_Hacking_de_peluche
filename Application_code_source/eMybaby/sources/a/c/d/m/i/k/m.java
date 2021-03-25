package a.c.d.m.i.k;

import a.c.a.f.b;
import a.c.d.s.e.d.a.b.a;

public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f628b;

    public m(n nVar, a aVar) {
        this.f628b = nVar;
        this.f627a = aVar;
    }

    public void run() {
        if (this.f627a.f42a.booleanValue()) {
            k.D(this.f628b.f635b, this.f627a.f983c);
            this.f628b.f634a.dismiss();
            return;
        }
        b.j0(this.f628b.f635b.getActivity(), this.f627a.f43b);
    }
}
