package a.c.d.m.i.k;

import a.c.a.f.b;
import a.c.d.r.i;
import a.c.d.s.e.d.b.b.a;
import android.view.View;
import java.util.Date;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f542b;

    public c(d dVar, a aVar) {
        this.f542b = dVar;
        this.f541a = aVar;
    }

    public void run() {
        this.f542b.f548a.dismiss();
        if (this.f541a.f42a.booleanValue()) {
            this.f542b.f551d.s();
            this.f542b.f551d.n.dismiss();
            this.f542b.f551d.s.setId(this.f541a.f1003c);
            e eVar = this.f542b.f551d;
            eVar.s.setDate(Long.valueOf(eVar.r.getTimeInMillis()));
            d dVar = this.f542b;
            dVar.f551d.s.setFirstValue(Boolean.valueOf(dVar.f549b));
            d dVar2 = this.f542b;
            dVar2.f551d.s.setSecondValue(Boolean.valueOf(dVar2.f550c));
            this.f542b.f551d.s.setTitle(i.d(new Date(this.f542b.f551d.s.getDate().longValue())));
            this.f542b.f551d.m.notifyDataSetChanged();
            e eVar2 = this.f542b.f551d;
            eVar2.u = false;
            eVar2.r = null;
            eVar2.y();
            e eVar3 = this.f542b.f551d;
            View view = eVar3.t;
            if (view != null) {
                view.setBackgroundResource(eVar3.p());
                return;
            }
            return;
        }
        b.j0(this.f542b.f551d.getActivity(), this.f541a.f43b);
    }
}
