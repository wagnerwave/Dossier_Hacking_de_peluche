package a.h.a;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import com.sozpic.miniland.NuevoCalendarioActivity;

public class s implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NuevoCalendarioActivity f3541a;

    public s(NuevoCalendarioActivity nuevoCalendarioActivity) {
        this.f3541a = nuevoCalendarioActivity;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        EditText editText = this.f3541a.w;
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("/");
        int i4 = i2 + 1;
        sb.append(i4);
        sb.append("/");
        sb.append(i);
        editText.setText(sb.toString());
        NuevoCalendarioActivity nuevoCalendarioActivity = this.f3541a;
        nuevoCalendarioActivity.k = i;
        nuevoCalendarioActivity.l = i4;
        nuevoCalendarioActivity.m = i3;
    }
}
