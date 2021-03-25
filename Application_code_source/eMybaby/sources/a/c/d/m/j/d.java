package a.c.d.m.j;

import a.c.d.r.j;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;
import java.util.Calendar;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f677a;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            d.this.f677a.u.set(1, i);
            d.this.f677a.u.set(2, i2);
            d.this.f677a.u.set(5, i3);
            AddAppointmentFormActivity addAppointmentFormActivity = d.this.f677a;
            addAppointmentFormActivity.q.setText(j.f.format(addAppointmentFormActivity.u.getTime()));
        }
    }

    public d(AddAppointmentFormActivity addAppointmentFormActivity) {
        this.f677a = addAppointmentFormActivity;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f677a, new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
