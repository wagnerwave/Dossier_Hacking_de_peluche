package a.c.d.m.i.k;

import a.c.d.r.j;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class e0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f574a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h0 f575b;

    public class a implements DatePickerDialog.OnDateSetListener {
        public a() {
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            h0 h0Var = e0.this.f575b;
            if (h0Var.w == null) {
                h0Var.w = Calendar.getInstance();
            }
            e0.this.f575b.w.set(1, i);
            e0.this.f575b.w.set(2, i2);
            e0.this.f575b.w.set(5, i3);
            e0 e0Var = e0.this;
            e0Var.f574a.setText(j.h.format(e0Var.f575b.w.getTime()));
        }
    }

    public e0(h0 h0Var, TextView textView) {
        this.f575b = h0Var;
        this.f574a = textView;
    }

    public void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        new DatePickerDialog(this.f575b.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5)).show();
    }
}
