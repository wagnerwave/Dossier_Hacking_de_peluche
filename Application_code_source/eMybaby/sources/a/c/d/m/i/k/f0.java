package a.c.d.m.i.k;

import a.c.d.m.i.k.h0;
import a.c.d.r.i;
import a.c.d.s.e.d.e.c.b;
import android.view.View;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;

public class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f581a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f582b;

    public f0(g0 g0Var, b bVar) {
        this.f582b = g0Var;
        this.f581a = bVar;
    }

    public void run() {
        this.f582b.f584a.dismiss();
        if (this.f581a.f42a.booleanValue()) {
            h0 h0Var = this.f582b.f586c;
            h0Var.B = false;
            h0Var.z.setIdCrecimiento(this.f581a.f1075c);
            g0 g0Var = this.f582b;
            g0Var.f586c.z.setValue(g0Var.f585b.floatValue());
            h0 h0Var2 = this.f582b.f586c;
            h0Var2.z.setDate(h0Var2.w.getTime());
            MeasurePregnancyMama measurePregnancyMama = this.f582b.f586c.z;
            measurePregnancyMama.setTitle(i.d(measurePregnancyMama.getDate()));
            this.f582b.f586c.u.notifyDataSetChanged();
            this.f582b.f586c.v.dismiss();
            h0 h0Var3 = this.f582b.f586c;
            View view = h0Var3.A;
            if (view != null) {
                view.setBackgroundResource(h0Var3.p());
            }
            h0Var3.z = null;
            h0Var3.y();
            h0 h0Var4 = this.f582b.f586c;
            float value = h0Var4.u.a(0).getValue();
            h0.i iVar = this.f582b.f586c.u;
            float value2 = iVar.a(iVar.getCount() - 1).getValue();
            h0.i iVar2 = this.f582b.f586c.u;
            h0.D(h0Var4, value, value2, iVar2.a(iVar2.getCount() - 1).getMeasureUnitName());
            return;
        }
        a.c.a.f.b.j0(this.f582b.f586c.getActivity(), this.f581a.f43b);
    }
}
