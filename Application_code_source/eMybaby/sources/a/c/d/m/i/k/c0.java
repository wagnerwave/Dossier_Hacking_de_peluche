package a.c.d.m.i.k;

import a.c.a.e.f;
import a.c.d.m.i.k.h0;
import a.c.d.s.e.d.e.a.b;
import android.app.ProgressDialog;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;

public class c0 implements a.c.d.s.e.d.e.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MeasurePregnancyMama f543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h0 f545c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f546a;

        public a(b bVar) {
            this.f546a = bVar;
        }

        public void run() {
            if (this.f546a.f42a.booleanValue()) {
                c0.this.f543a.setIdCrecimiento(this.f546a.f1066c);
                c0 c0Var = c0.this;
                h0 h0Var = c0Var.f545c;
                h0Var.w = null;
                h0.i iVar = h0Var.u;
                iVar.f599a.add(c0Var.f543a);
                c0.this.f545c.u.notifyDataSetChanged();
                h0 h0Var2 = c0.this.f545c;
                float value = h0Var2.u.a(0).getValue();
                h0.i iVar2 = c0.this.f545c.u;
                h0.D(h0Var2, value, iVar2.a(iVar2.getCount() - 1).getValue(), c0.this.f545c.u.a(0).getMeasureUnitName());
                c0.this.f545c.v.dismiss();
                f.c().d("MI_EMBARAZO", "MAMA_NUEVO_PESO", "");
                c0.this.f545c.s();
            } else {
                a.c.a.f.b.j0(c0.this.f545c.getActivity(), this.f546a.f43b);
            }
            c0.this.f544b.hide();
        }
    }

    public c0(h0 h0Var, MeasurePregnancyMama measurePregnancyMama, ProgressDialog progressDialog) {
        this.f545c = h0Var;
        this.f543a = measurePregnancyMama;
        this.f544b = progressDialog;
    }

    public void a(b bVar) {
        this.f545c.getActivity().runOnUiThread(new a(bVar));
    }
}
