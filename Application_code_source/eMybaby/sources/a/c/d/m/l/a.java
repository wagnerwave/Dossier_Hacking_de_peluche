package a.c.d.m.l;

import a.c.a.f.b;
import a.c.d.s.e.g.b.c;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import com.cuatroochenta.miniland.pregnancy.sounds.PregnancySoundsListActivity;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancySoundsListActivity f716b;

    public a(PregnancySoundsListActivity pregnancySoundsListActivity, c cVar) {
        this.f716b = pregnancySoundsListActivity;
        this.f715a = cVar;
    }

    public void run() {
        this.f716b.o();
        if (this.f715a.f42a.booleanValue()) {
            PregnancySoundsListActivity pregnancySoundsListActivity = this.f716b;
            ArrayList<HeartBeatSound> arrayList = this.f715a.f1120c;
            c cVar = (c) pregnancySoundsListActivity.f4074b.getAdapter();
            if (cVar == null) {
                cVar = new c(pregnancySoundsListActivity);
                pregnancySoundsListActivity.f4074b.setAdapter(cVar);
            }
            cVar.f722d = 1;
            cVar.f721c.clear();
            cVar.f720b.clear();
            if (arrayList != null) {
                cVar.f720b.addAll(arrayList);
            }
            cVar.notifyDataSetChanged();
            return;
        }
        b.h0(this.f716b, a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_EMBARAZO_SOUNDS), a.c.a.d.a.h(R.string.TR_ACEPTAR));
    }
}
