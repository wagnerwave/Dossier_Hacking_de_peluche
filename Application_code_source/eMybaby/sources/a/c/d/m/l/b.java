package a.c.d.m.l;

import a.c.a.d.a;
import com.cuatroochenta.miniland.pregnancy.sounds.PregnancySoundsListActivity;
import com.sozpic.miniland.R;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.c.d.s.e.g.a.b f717a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancySoundsListActivity f718b;

    public b(PregnancySoundsListActivity pregnancySoundsListActivity, a.c.d.s.e.g.a.b bVar) {
        this.f718b = pregnancySoundsListActivity;
        this.f717a = bVar;
    }

    public void run() {
        this.f718b.o();
        if (this.f717a.f42a.booleanValue()) {
            c cVar = (c) this.f718b.f4074b.getAdapter();
            if (!(cVar == null || cVar.f722d == 1)) {
                cVar.a();
                this.f718b.f4075c.setVisibility(8);
            }
            this.f718b.r();
            return;
        }
        a.c.a.f.b.h0(this.f718b, a.h(R.string.TR_ERROR_DELETING_PREGNANCY_SOUNDS), a.h(R.string.TR_ACEPTAR));
    }
}
