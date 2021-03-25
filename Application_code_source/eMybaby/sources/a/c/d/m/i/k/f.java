package a.c.d.m.i.k;

import a.c.d.m.i.k.e;
import a.c.d.s.e.d.b.d.b;
import android.app.ProgressDialog;
import android.view.View;

public class f implements a.c.d.s.e.d.b.d.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f578b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f579a;

        public a(b bVar) {
            this.f579a = bVar;
        }

        public void run() {
            f.this.f577a.dismiss();
            if (this.f579a.f42a.booleanValue()) {
                e eVar = f.this.f578b;
                View view = eVar.t;
                if (view != null) {
                    view.setBackgroundResource(eVar.p());
                    e eVar2 = f.this.f578b;
                    e.i iVar = eVar2.m;
                    iVar.f566a.remove(eVar2.s);
                    f.this.f578b.m.notifyDataSetChanged();
                }
                f.this.f578b.y();
                return;
            }
            a.c.a.f.b.j0(f.this.f578b.getActivity(), this.f579a.f43b);
        }
    }

    public f(e eVar, ProgressDialog progressDialog) {
        this.f578b = eVar;
        this.f577a = progressDialog;
    }

    public void c(b bVar) {
        this.f578b.getActivity().runOnUiThread(new a(bVar));
    }
}
