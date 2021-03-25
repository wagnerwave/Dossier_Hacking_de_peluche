package a.h.a;

import a.a.a.a.a;
import android.app.TimePickerDialog;
import android.widget.EditText;
import android.widget.TimePicker;
import com.sozpic.miniland.NuevoCalendarioActivity;
import com.tuya.smart.common.oOO0O0O0;

public class q implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NuevoCalendarioActivity f3539a;

    public q(NuevoCalendarioActivity nuevoCalendarioActivity) {
        this.f3539a = nuevoCalendarioActivity;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f3539a.r = i2 < 10 ? a.h(oOO0O0O0.O0000oO0, i2) : String.valueOf(i2);
        this.f3539a.q = i < 10 ? a.h(oOO0O0O0.O0000oO0, i) : String.valueOf(i);
        EditText editText = this.f3539a.y;
        editText.setText(this.f3539a.q + ":" + this.f3539a.r);
    }
}
