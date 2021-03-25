package a.c.d.m.e.k;

import a.c.d.s.e.a.b.b.b;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f374a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f375b;

    public g(h hVar, b bVar) {
        this.f375b = hVar;
        this.f374a = bVar;
    }

    public void run() {
        if (this.f374a.f42a.booleanValue()) {
            h hVar = this.f375b;
            a aVar = hVar.f378c.j;
            int i = hVar.f376a;
            aVar.h(aVar.j);
            aVar.f();
            aVar.f803a.remove(i);
            this.f375b.f378c.j.notifyDataSetChanged();
        } else {
            a.c.a.f.b.j0(this.f375b.f378c.getActivity(), this.f374a.f43b);
        }
        this.f375b.f377b.dismiss();
    }
}
