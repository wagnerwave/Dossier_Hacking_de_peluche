package a.c.d.m.f;

import a.c.a.f.b;
import a.c.d.m.f.i;
import a.c.d.s.e.a.a.b.a;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i.a.C0025a f441b;

    public h(i.a.C0025a aVar, a aVar2) {
        this.f441b = aVar;
        this.f440a = aVar2;
    }

    public void run() {
        i.this.f442a.q();
        this.f441b.f444a.dismiss();
        if (this.f440a.f42a.booleanValue()) {
            p pVar = i.this.f442a.k;
            n a2 = pVar.a();
            a2.f803a.remove(a2.f);
            a2.f455d = false;
            a2.g.q();
            pVar.a().notifyDataSetChanged();
            if (pVar.a().getCount() == 0) {
                pVar.f457a.remove(pVar.f458b.getCurrentItem());
                pVar.notifyDataSetChanged();
            }
            i.this.f442a.k.notifyDataSetChanged();
            i.this.f442a.q();
            return;
        }
        b.j0(i.this.f442a, this.f440a.f43b);
    }
}
