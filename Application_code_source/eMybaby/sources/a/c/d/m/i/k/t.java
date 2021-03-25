package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.d.r.i;
import a.c.d.s.e.d.c.a.b;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Locale;

public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f658a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f659b;

    public t(s sVar, b bVar) {
        this.f659b = sVar;
        this.f658a = bVar;
    }

    public void run() {
        this.f659b.s();
        if (this.f658a.f42a.booleanValue()) {
            this.f659b.n.dismiss();
            MeasurePregnancyMama measurePregnancyMama = new MeasurePregnancyMama();
            measurePregnancyMama.setTitle(String.format(Locale.getDefault(), a.i(R.string.TR_SEMANA_PLACEHOLDER), new Object[]{Integer.valueOf(AppMiniland.f().h()), Integer.valueOf(((AppMiniland) a.c.a.a.f).g())}));
            measurePregnancyMama.setIdCrecimiento(this.f658a.f1018c);
            measurePregnancyMama.setDate(this.f659b.q.getTime());
            measurePregnancyMama.setValue(Float.parseFloat(this.f659b.o.getText().toString()));
            measurePregnancyMama.setTitle(i.d(measurePregnancyMama.getDate()));
            this.f659b.m.f653a.add(measurePregnancyMama);
            this.f659b.m.notifyDataSetChanged();
            this.f659b.q = null;
            return;
        }
        a.c.a.f.b.j0(this.f659b.getActivity(), this.f658a.f43b);
    }
}
