package a.c.d.m.j;

import a.c.d.s.e.e.a.b;
import android.content.Intent;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f682b;

    public f(g gVar, b bVar) {
        this.f682b = gVar;
        this.f681a = bVar;
    }

    public void run() {
        this.f682b.f683a.dismiss();
        if (this.f681a.f42a.booleanValue()) {
            if (this.f682b.f685c.f4059b.isChecked()) {
                g gVar = this.f682b;
                AddAppointmentFormActivity.q(gVar.f685c, gVar.f684b);
            }
            this.f682b.f685c.setResult(-1, new Intent().putExtra("ARGS_NEW_APPOINTMENT", this.f682b.f684b));
            a.c.a.e.f.c().d("MI_EMBARAZO", "CITA_MEDIA_NUEVA", "");
            this.f682b.f685c.finish();
            return;
        }
        a.c.a.f.b.j0(this.f682b.f685c, this.f681a.f43b);
    }
}
