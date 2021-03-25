package a.c.d.m.j;

import a.c.d.s.e.e.c.a;
import a.c.d.s.e.e.c.b;
import android.app.ProgressDialog;
import com.cuatroochenta.miniland.model.MedicalAppointment;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class h implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MedicalAppointment f687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f688c;

    public h(AddAppointmentFormActivity addAppointmentFormActivity, ProgressDialog progressDialog, MedicalAppointment medicalAppointment) {
        this.f688c = addAppointmentFormActivity;
        this.f686a = progressDialog;
        this.f687b = medicalAppointment;
    }

    public void a(b bVar) {
        this.f686a.dismiss();
        if (bVar.f42a.booleanValue()) {
            if (this.f688c.f4059b.isChecked()) {
                AddAppointmentFormActivity.q(this.f688c, this.f687b);
            }
            this.f688c.setResult(-1);
            this.f688c.finish();
            return;
        }
        a.c.a.f.b.j0(this.f688c, bVar.f43b);
    }
}
