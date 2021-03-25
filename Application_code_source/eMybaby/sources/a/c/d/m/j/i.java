package a.c.d.m.j;

import a.c.d.s.e.e.b.b;
import a.c.d.s.e.e.b.c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.delete.MedicalAppointmentDeleteRequest;
import com.sozpic.miniland.R;

public class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f689a;

    public class a implements a.c.d.s.e.e.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f690a;

        /* renamed from: a.c.d.m.j.i$a$a  reason: collision with other inner class name */
        public class C0030a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f692a;

            public C0030a(b bVar) {
                this.f692a = bVar;
            }

            public void run() {
                a.this.f690a.dismiss();
                if (this.f692a.f42a.booleanValue()) {
                    i.this.f689a.setResult(-1);
                    i.this.f689a.finish();
                    return;
                }
                a.c.a.f.b.j0(i.this.f689a, a.c.a.d.a.h(R.string.TR_ERROR_BORRAR_CITA_MEDICA));
            }
        }

        public a(ProgressDialog progressDialog) {
            this.f690a = progressDialog;
        }

        public void a(b bVar) {
            i.this.f689a.runOnUiThread(new C0030a(bVar));
        }
    }

    public i(AddAppointmentFormActivity addAppointmentFormActivity) {
        this.f689a = addAppointmentFormActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ProgressDialog progressDialog = new ProgressDialog(this.f689a);
        progressDialog.show();
        new c().a(new MedicalAppointmentDeleteRequest(this.f689a.w), new a(progressDialog));
    }
}
