package a.c.d.m.e.k;

import android.app.ProgressDialog;

public class b implements a.c.d.s.e.a.b.d.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f364b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.a.b.d.b f365a;

        public a(a.c.d.s.e.a.b.d.b bVar) {
            this.f365a = bVar;
        }

        public void run() {
            a aVar = b.this.f364b.j;
            aVar.f803a = this.f365a.f930c;
            aVar.notifyDataSetChanged();
            b.this.f363a.dismiss();
        }
    }

    public b(i iVar, ProgressDialog progressDialog) {
        this.f364b = iVar;
        this.f363a = progressDialog;
    }

    public void a(a.c.d.s.e.a.b.d.b bVar) {
        this.f364b.getActivity().runOnUiThread(new a(bVar));
    }
}
