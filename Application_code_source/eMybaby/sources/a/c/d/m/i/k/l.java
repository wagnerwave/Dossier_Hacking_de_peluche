package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.d.a.a.b;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Date;
import java.util.Locale;

public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f625a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f626b;

    public l(k kVar, b bVar) {
        this.f626b = kVar;
        this.f625a = bVar;
    }

    public void run() {
        if (this.f625a.f42a.booleanValue()) {
            this.f626b.n.dismiss();
            this.f626b.s();
            MeasureWithTwoValues measureWithTwoValues = new MeasureWithTwoValues(this.f625a.f978c.longValue(), Integer.valueOf(Integer.parseInt(this.f626b.s.getText().toString())), Integer.valueOf(Integer.parseInt(this.f626b.t.getText().toString())), String.format(Locale.getDefault(), a.i(R.string.TR_SEMANA_PLACEHOLDER), new Object[]{String.valueOf(AppMiniland.f().h()), String.valueOf(((AppMiniland) a.c.a.a.f).g())}), j.f.format(this.f626b.o.getTime()));
            measureWithTwoValues.setDate(Long.valueOf(this.f626b.o.getTime().getTime()));
            measureWithTwoValues.setTitle(i.d(new Date(measureWithTwoValues.getDate().longValue())));
            this.f626b.m.f618a.add(measureWithTwoValues);
            this.f626b.m.notifyDataSetChanged();
            f.c().d("MI_EMBARAZO", "MAMA_NUEVA_TENSION", "");
            return;
        }
        a.c.a.f.b.j0(this.f626b.getActivity(), this.f625a.f43b);
    }
}
