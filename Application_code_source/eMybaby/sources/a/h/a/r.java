package a.h.a;

import android.app.TimePickerDialog;
import android.widget.EditText;
import android.widget.TimePicker;
import com.sozpic.miniland.NuevoCalendarioActivity;
import com.tuya.smart.common.oOO0O0O0;

public class r implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NuevoCalendarioActivity f3540a;

    public r(NuevoCalendarioActivity nuevoCalendarioActivity) {
        this.f3540a = nuevoCalendarioActivity;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        StringBuilder sb;
        NuevoCalendarioActivity nuevoCalendarioActivity = this.f3540a;
        if (i2 < 10) {
            sb.append(oOO0O0O0.O0000oO0);
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(i2);
        nuevoCalendarioActivity.u = sb.toString();
        NuevoCalendarioActivity nuevoCalendarioActivity2 = this.f3540a;
        StringBuilder sb2 = new StringBuilder();
        if (i < 10) {
            sb2.append(oOO0O0O0.O0000oO0);
        } else {
            sb2.append("");
        }
        sb2.append(i);
        nuevoCalendarioActivity2.t = sb2.toString();
        EditText editText = this.f3540a.z;
        editText.setText(this.f3540a.t + ":" + this.f3540a.u + ":00");
    }
}
