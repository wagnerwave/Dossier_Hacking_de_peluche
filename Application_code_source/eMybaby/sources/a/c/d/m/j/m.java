package a.c.d.m.j;

import a.c.d.s.e.e.b.c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.delete.MedicalAppointmentDeleteRequest;
import com.sozpic.miniland.R;

public class m implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppointmentListActivity f695a;

    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f696a;

        /* renamed from: a.c.d.m.j.m$a$a  reason: collision with other inner class name */
        public class C0031a implements a.c.d.s.e.e.b.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f698a;

            /* renamed from: a.c.d.m.j.m$a$a$a  reason: collision with other inner class name */
            public class C0032a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a.c.d.s.e.e.b.b f700a;

                public C0032a(a.c.d.s.e.e.b.b bVar) {
                    this.f700a = bVar;
                }

                public void run() {
                    C0031a.this.f698a.dismiss();
                    if (this.f700a.f42a.booleanValue()) {
                        m.this.f695a.r();
                    } else {
                        a.c.a.f.b.j0(m.this.f695a, a.c.a.d.a.h(R.string.TR_ERROR_BORRAR_CITA_MEDICA));
                    }
                }
            }

            public C0031a(ProgressDialog progressDialog) {
                this.f698a = progressDialog;
            }

            public void a(a.c.d.s.e.e.b.b bVar) {
                m.this.f695a.runOnUiThread(new C0032a(bVar));
            }
        }

        public a(int i) {
            this.f696a = i;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ProgressDialog progressDialog = new ProgressDialog(m.this.f695a);
            progressDialog.show();
            new c().a(new MedicalAppointmentDeleteRequest(m.this.f695a.f.a(this.f696a)), new C0031a(progressDialog));
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b(m mVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public m(AppointmentListActivity appointmentListActivity) {
        this.f695a = appointmentListActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        new AlertDialog.Builder(this.f695a).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new b(this)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_MEDICAL_APPOINTMENT_CONFIRM_DIALOG)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new a(i)).show();
        return true;
    }
}
