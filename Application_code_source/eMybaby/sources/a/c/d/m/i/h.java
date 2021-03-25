package a.c.d.m.i;

import a.c.d.m.i.i;
import a.c.d.s.e.d.d.b.b;
import com.cuatroochenta.miniland.pregnancy.mama.MyBellyImageFormActivity;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f502a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i.a f503b;

    public h(i.a aVar, b bVar) {
        this.f503b = aVar;
        this.f502a = bVar;
    }

    public void run() {
        if (this.f502a.f42a.booleanValue()) {
            this.f503b.f505a.dismiss();
            this.f503b.f506b.setId(Long.valueOf(this.f502a.f1047c));
            i.a aVar = this.f503b;
            MyBellyImageFormActivity.q(i.this.f504a, aVar.f506b);
            return;
        }
        a.c.a.f.b.j0(i.this.f504a, this.f502a.f43b);
    }
}
