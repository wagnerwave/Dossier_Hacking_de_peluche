package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.d.m.i.k.h0;
import a.c.d.s.e.d.e.b.b;
import android.view.View;
import android.view.WindowManager;
import com.sozpic.miniland.R;

public class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h0 f607b;

    public i0(h0 h0Var, b bVar) {
        this.f607b = h0Var;
        this.f606a = bVar;
    }

    public void run() {
        this.f607b.s();
        if (this.f606a.f42a.booleanValue()) {
            h0.i iVar = this.f607b.u;
            iVar.f599a.remove(h0.this.z);
            h0 h0Var = this.f607b;
            View view = h0Var.A;
            if (view != null) {
                view.setBackgroundResource(h0Var.p());
                this.f607b.y();
                h0 h0Var2 = this.f607b;
                h0Var2.A = null;
                h0Var2.z = null;
                h0Var2.u.notifyDataSetChanged();
            }
            if (this.f607b.u.getCount() == 1) {
                h0 h0Var3 = this.f607b;
                h0.D(h0Var3, h0Var3.u.a(0).getValue(), this.f607b.u.a(0).getValue(), this.f607b.u.a(0).getMeasureUnitName());
            } else if (this.f607b.u.getCount() == 0) {
                h0.D(this.f607b, 0.0f, 0.0f, a.h(R.string.TR_UNIT_TYPE_KGS));
            } else {
                h0 h0Var4 = this.f607b;
                float value = h0Var4.u.a(0).getValue();
                h0.i iVar2 = this.f607b.u;
                float value2 = iVar2.a(iVar2.getCount() - 1).getValue();
                h0.i iVar3 = this.f607b.u;
                h0.D(h0Var4, value, value2, iVar3.a(iVar3.getCount() - 1).getMeasureUnitName());
            }
            if (this.f607b.isAdded()) {
                try {
                    a.c.a.f.b.l0(this.f607b.getActivity(), a.h(R.string.TR_DELETE_PESOS_EMBARAZO_OK), a.h(R.string.TR_ACEPTAR));
                } catch (WindowManager.BadTokenException unused) {
                }
            }
        } else {
            a.c.a.f.b.h0(this.f607b.getActivity(), a.h(R.string.TR_DELETE_PESOS_EMBARAZO_KO), a.h(R.string.TR_ACEPTAR));
        }
    }
}
