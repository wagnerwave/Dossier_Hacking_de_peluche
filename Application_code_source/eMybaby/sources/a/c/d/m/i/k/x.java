package a.c.d.m.i.k;

import a.c.d.r.j;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f665a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f666b;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            s sVar = x.this.f666b;
            if (sVar.q == null) {
                sVar.q = Calendar.getInstance();
            }
            x.this.f666b.q.set(1, i);
            x.this.f666b.q.set(2, i2);
            x.this.f666b.q.set(5, i3);
            x xVar = x.this;
            xVar.f665a.setText(j.h.format(xVar.f666b.q.getTime()));
        }
    }

    public x(s sVar, TextView textView) {
        this.f666b = sVar;
        this.f665a = textView;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f666b.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
