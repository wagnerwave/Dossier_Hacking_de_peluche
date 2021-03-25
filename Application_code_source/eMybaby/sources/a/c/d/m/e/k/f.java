package a.c.d.m.e.k;

import a.c.d.s.e.a.b.a.b;
import android.app.ProgressDialog;
import com.cuatroochenta.miniland.model.MedicalDataEntry;

public class f implements a.c.d.s.e.a.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MedicalDataEntry f369a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f370b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f371c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f372a;

        public a(b bVar) {
            this.f372a = bVar;
        }

        public void run() {
            if (this.f372a.f42a.booleanValue()) {
                f.this.f369a.setId(this.f372a.f916c);
                f fVar = f.this;
                a aVar = fVar.f371c.j;
                aVar.f803a.add(fVar.f369a);
                f.this.f371c.j.notifyDataSetChanged();
            } else {
                a.c.a.f.b.j0(f.this.f371c.getActivity(), this.f372a.f43b);
            }
            f.this.f370b.dismiss();
        }
    }

    public f(i iVar, MedicalDataEntry medicalDataEntry, ProgressDialog progressDialog) {
        this.f371c = iVar;
        this.f369a = medicalDataEntry;
        this.f370b = progressDialog;
    }

    public void a(b bVar) {
        this.f371c.getActivity().runOnUiThread(new a(bVar));
    }
}
