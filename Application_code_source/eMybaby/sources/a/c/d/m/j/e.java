package a.c.d.m.j;

import a.c.d.r.j;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.TimePicker;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;
import java.util.Calendar;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f679a;

    public class a implements TimePickerDialog.OnTimeSetListener {
        public a() {
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            e.this.f679a.u.set(11, i);
            e.this.f679a.u.set(12, i2);
            AddAppointmentFormActivity addAppointmentFormActivity = e.this.f679a;
            addAppointmentFormActivity.p.setText(j.l.format(addAppointmentFormActivity.u.getTime()));
        }
    }

    public e(AddAppointmentFormActivity addAppointmentFormActivity) {
        this.f679a = addAppointmentFormActivity;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new TimePickerDialog(this.f679a, new a(), instance.get(11), instance.get(12), true).show();
    }
}
