package a.h.a;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import com.sozpic.miniland.NuevoCalendarioActivity;

public class t implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NuevoCalendarioActivity f3542a;

    public t(NuevoCalendarioActivity nuevoCalendarioActivity) {
        this.f3542a = nuevoCalendarioActivity;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        EditText editText = this.f3542a.x;
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("/");
        int i4 = i2 + 1;
        sb.append(i4);
        sb.append("/");
        sb.append(i);
        editText.setText(sb.toString());
        NuevoCalendarioActivity nuevoCalendarioActivity = this.f3542a;
        nuevoCalendarioActivity.n = i;
        nuevoCalendarioActivity.o = i4;
        nuevoCalendarioActivity.p = i3;
    }
}
