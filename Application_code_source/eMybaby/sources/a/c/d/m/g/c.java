package a.c.d.m.g;

import a.c.a.d.a;
import a.c.d.s.e.b.b.b;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.sozpic.miniland.R;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancyContractionListActivity f478b;

    public c(PregnancyContractionListActivity pregnancyContractionListActivity, b bVar) {
        this.f478b = pregnancyContractionListActivity;
        this.f477a = bVar;
    }

    public void run() {
        PregnancyContractionListActivity pregnancyContractionListActivity = this.f478b;
        int i = pregnancyContractionListActivity.h - 1;
        pregnancyContractionListActivity.h = i;
        if (i == 0) {
            d dVar = (d) pregnancyContractionListActivity.f3978b.getAdapter();
            if (dVar != null && dVar.f482d == 2) {
                dVar.a();
                this.f478b.f3979c.setVisibility(8);
            }
            this.f478b.o();
            if (this.f477a.f42a.booleanValue()) {
                a.c.a.f.b.h0(this.f478b, a.h(R.string.TR_DELETE_CONTRACCION_OK), a.h(R.string.TR_ACEPTAR));
                this.f478b.t();
                return;
            }
            a.c.a.f.b.h0(this.f478b, a.h(R.string.TR_DELETE_CONTRACCION_KO), a.h(R.string.TR_ACEPTAR));
        }
    }
}
