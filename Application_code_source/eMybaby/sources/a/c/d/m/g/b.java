package a.c.d.m.g;

import a.c.d.s.e.b.c.c;
import com.cuatroochenta.miniland.model.Contraction;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import java.util.ArrayList;
import java.util.Collections;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f475a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancyContractionListActivity f476b;

    public b(PregnancyContractionListActivity pregnancyContractionListActivity, c cVar) {
        this.f476b = pregnancyContractionListActivity;
        this.f475a = cVar;
    }

    public void run() {
        this.f476b.o();
        if (this.f475a.f42a.booleanValue()) {
            PregnancyContractionListActivity pregnancyContractionListActivity = this.f476b;
            ArrayList<Contraction> arrayList = this.f475a.f974c;
            d dVar = (d) pregnancyContractionListActivity.f3978b.getAdapter();
            if (dVar == null) {
                dVar = new d(pregnancyContractionListActivity);
                pregnancyContractionListActivity.f3978b.setAdapter(dVar);
            }
            dVar.f482d = 1;
            dVar.f481c.clear();
            dVar.f480b.clear();
            if (arrayList != null) {
                dVar.f480b.addAll(arrayList);
            }
            Collections.sort(dVar.f480b);
            dVar.notifyDataSetChanged();
            return;
        }
        a.c.a.f.b.j0(this.f476b, this.f475a.f43b);
    }
}
