package a.c.d.m.i.k;

import a.c.d.r.j;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f642a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f643b;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            k kVar = r.this.f643b;
            if (kVar.o == null) {
                kVar.o = Calendar.getInstance();
            }
            r.this.f643b.o.set(1, i);
            r.this.f643b.o.set(2, i2);
            r.this.f643b.o.set(5, i3);
            r rVar = r.this;
            rVar.f642a.setText(j.h.format(rVar.f643b.o.getTime()));
        }
    }

    public r(k kVar, TextView textView) {
        this.f643b = kVar;
        this.f642a = textView;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f643b.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
