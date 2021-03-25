package a.c.d.m.j;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AppointmentListActivity;

public class l implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppointmentListActivity f694a;

    public l(AppointmentListActivity appointmentListActivity) {
        this.f694a = appointmentListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppointmentListActivity appointmentListActivity = this.f694a;
        Intent intent = new Intent(appointmentListActivity, AddAppointmentFormActivity.class);
        intent.putExtra("ARGS_NEW_APPOINTMENT", this.f694a.f.f703a.get(i));
        appointmentListActivity.startActivityForResult(intent, 48204);
    }
}
