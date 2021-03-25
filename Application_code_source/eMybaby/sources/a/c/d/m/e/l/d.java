package a.c.d.m.e.l;

import a.c.d.m.e.l.c;
import a.c.d.s.e.a.c.c.b;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c.b f412b;

    public d(c.b bVar, b bVar2) {
        this.f412b = bVar;
        this.f411a = bVar2;
    }

    public void run() {
        this.f412b.f409a.dismiss();
        if (this.f411a.f42a.booleanValue()) {
            UltrasoundFormActivity.q(c.this.f404a, this.f411a.f949c);
        } else {
            a.c.a.f.b.j0(c.this.f404a, this.f411a.f43b);
        }
    }
}
