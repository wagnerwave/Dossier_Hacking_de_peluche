package a.c.d.m.e.k;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;
import java.util.Calendar;

public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MedicalDataFormActivity f384a;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            j.this.f384a.p = Calendar.getInstance();
            j.this.f384a.p.set(1, i);
            j.this.f384a.p.set(2, i2);
            j.this.f384a.p.set(5, i3);
            MedicalDataFormActivity medicalDataFormActivity = j.this.f384a;
            medicalDataFormActivity.o.setText(a.c.d.r.j.h.format(medicalDataFormActivity.p.getTime()));
        }
    }

    public j(MedicalDataFormActivity medicalDataFormActivity) {
        this.f384a = medicalDataFormActivity;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f384a, new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
