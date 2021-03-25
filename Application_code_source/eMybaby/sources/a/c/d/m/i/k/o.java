package a.c.d.m.i.k;

import a.c.d.m.i.k.k;
import a.c.d.s.e.d.a.d.b;

public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f636a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f637b;

    public o(k kVar, b bVar) {
        this.f637b = kVar;
        this.f636a = bVar;
    }

    public void run() {
        if (this.f636a.f42a.booleanValue()) {
            k.g gVar = this.f637b.m;
            gVar.f618a.remove(k.this.p);
            this.f637b.m.notifyDataSetChanged();
            this.f637b.y();
            k kVar = this.f637b;
            kVar.q.setBackgroundResource(kVar.p());
            k kVar2 = this.f637b;
            kVar2.q = null;
            kVar2.n.dismiss();
        } else {
            a.c.a.f.b.j0(this.f637b.getActivity(), this.f636a.f43b);
        }
        this.f637b.s();
    }
}
