package a.c.d.m.i.k;

import a.c.a.e.f;
import a.c.d.r.i;
import a.c.d.s.e.d.b.a.b;
import android.app.ProgressDialog;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Date;
import java.util.Locale;

public class a implements a.c.d.s.e.d.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Boolean f514a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Boolean f515b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f516c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f517d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f518e;

    /* renamed from: a.c.d.m.i.k.a$a  reason: collision with other inner class name */
    public class C0026a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f519a;

        public C0026a(b bVar) {
            this.f519a = bVar;
        }

        public void run() {
            if (this.f519a.f42a.booleanValue()) {
                a.this.f518e.o.setTag(Boolean.FALSE);
                a.this.f518e.o.clearColorFilter();
                a.this.f518e.p.setTag(Boolean.FALSE);
                a.this.f518e.p.clearColorFilter();
                a.this.f518e.r = null;
                long longValue = this.f519a.f998c.longValue();
                a aVar = a.this;
                MeasureWithTwoValues measureWithTwoValues = new MeasureWithTwoValues(longValue, aVar.f514a, aVar.f515b, String.format(Locale.getDefault(), a.c.a.d.a.i(R.string.TR_SEMANA_PLACEHOLDER), new Object[]{Integer.valueOf(AppMiniland.f().h()), Integer.valueOf(((AppMiniland) a.c.a.a.f).g())}), a.this.f516c);
                measureWithTwoValues.setTitle(i.d(new Date(measureWithTwoValues.getDate().longValue())));
                a.this.f518e.m.f566a.add(measureWithTwoValues);
                a.this.f518e.m.notifyDataSetChanged();
                a.this.f518e.n.dismiss();
                f.c().d("MI_EMBARAZO", "MAMA_MOV_FETAL", "");
                a.this.f518e.s();
            } else {
                a.c.a.f.b.j0(a.this.f518e.getActivity(), this.f519a.f43b);
            }
            a.this.f517d.dismiss();
        }
    }

    public a(e eVar, Boolean bool, Boolean bool2, String str, ProgressDialog progressDialog) {
        this.f518e = eVar;
        this.f514a = bool;
        this.f515b = bool2;
        this.f516c = str;
        this.f517d = progressDialog;
    }

    public void g(b bVar) {
        this.f518e.getActivity().runOnUiThread(new C0026a(bVar));
    }
}
