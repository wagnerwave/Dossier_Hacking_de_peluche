package a.c.d.m.j;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentActivity;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentActivity f674b;

    public a(AddAppointmentActivity addAppointmentActivity, int i) {
        this.f674b = addAppointmentActivity;
        this.f673a = i;
    }

    public void onClick(View view) {
        AddAppointmentActivity addAppointmentActivity = this.f674b;
        int i = this.f673a;
        Intent intent = new Intent(addAppointmentActivity, AddAppointmentFormActivity.class);
        intent.putExtra("ARGS_APPOINTMENT_TYPE", i);
        addAppointmentActivity.startActivityForResult(intent, 42332);
    }
}
