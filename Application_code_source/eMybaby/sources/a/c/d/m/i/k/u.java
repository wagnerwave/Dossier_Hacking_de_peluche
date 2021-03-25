package a.c.d.m.i.k;

import a.c.d.m.i.k.s;
import a.c.d.s.e.d.c.d.b;

public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f661b;

    public u(s sVar, b bVar) {
        this.f661b = sVar;
        this.f660a = bVar;
    }

    public void run() {
        if (this.f660a.f42a.booleanValue()) {
            this.f661b.n.dismiss();
            s sVar = this.f661b;
            s.g gVar = sVar.m;
            gVar.f653a.remove(sVar.r);
            this.f661b.m.notifyDataSetChanged();
            this.f661b.y();
            s sVar2 = this.f661b;
            sVar2.s.setBackgroundResource(sVar2.p());
            this.f661b.q = null;
        } else {
            a.c.a.f.b.j0(this.f661b.getActivity(), this.f660a.f43b);
        }
        this.f661b.s();
    }
}
