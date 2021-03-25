package a.c.d.m.i.k;

import a.c.a.a;
import a.c.d.m.i.k.a0;
import a.c.d.s.e.d.d.d.b;
import com.cuatroochenta.miniland.pregnancy.mama.MamaMainActivity;
import com.sozpic.miniland.R;

public class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f539a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f540b;

    public b0(a0 a0Var, b bVar) {
        this.f540b = a0Var;
        this.f539a = bVar;
    }

    public void run() {
        this.f540b.s();
        if (this.f539a.f42a.booleanValue()) {
            a0 a0Var = this.f540b;
            a0.g gVar = a0Var.m;
            gVar.f530b.remove(a0Var.q);
            this.f540b.m.notifyDataSetChanged();
            if (this.f540b.m.getCount() == 0) {
                a.c.a.f.b.o0(this.f540b.getActivity(), a.f.c(a.c.a.d.a.h(R.string.TR_YA_NO_QUEDAN_TRIPITAS)));
                if (this.f540b.getActivity() instanceof MamaMainActivity) {
                    ((MamaMainActivity) this.f540b.getActivity()).q(MamaMainActivity.b.MAMA_OPTION_WEIGHT_EVOLUTION);
                }
                this.f540b.y();
                return;
            }
            a0 a0Var2 = this.f540b;
            a0.g gVar2 = a0Var2.m;
            a0Var2.q = gVar2.f530b.get(a0Var2.l.getCurrentItem());
            a0 a0Var3 = this.f540b;
            a0Var3.n.setText(a0Var3.q.getTitle());
            a0 a0Var4 = this.f540b;
            a0Var4.o.setText(a0Var4.q.getDescription());
            a.c.a.f.b.l0(this.f540b.getActivity(), a.c.a.d.a.h(R.string.TR_DELETE_MI_TRIPITA_OK), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            return;
        }
        a.c.a.f.b.h0(this.f540b.getActivity(), a.c.a.d.a.h(R.string.TR_DELETE_MI_TRIPITA_KO), a.c.a.d.a.h(R.string.TR_ACEPTAR));
    }
}
