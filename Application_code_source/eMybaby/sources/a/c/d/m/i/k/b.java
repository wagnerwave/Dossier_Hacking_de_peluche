package a.c.d.m.i.k;

import a.c.d.r.j;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f536a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f537b;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            e eVar = b.this.f537b;
            if (eVar.r == null) {
                eVar.r = Calendar.getInstance();
            }
            b.this.f537b.r.set(1, i);
            b.this.f537b.r.set(2, i2);
            b.this.f537b.r.set(5, i3);
            b bVar = b.this;
            bVar.f536a.setText(j.h.format(bVar.f537b.r.getTime()));
        }
    }

    public b(e eVar, TextView textView) {
        this.f537b = eVar;
        this.f536a = textView;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f537b.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
