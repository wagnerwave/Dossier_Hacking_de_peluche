package a.c.d.m.j;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentActivity;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity;

public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppointmentListActivity f702a;

    public n(AppointmentListActivity appointmentListActivity) {
        this.f702a = appointmentListActivity;
    }

    public void onClick(View view) {
        AppointmentListActivity appointmentListActivity = this.f702a;
        appointmentListActivity.startActivityForResult(new Intent(appointmentListActivity, AddAppointmentActivity.class), 48203);
    }
}
