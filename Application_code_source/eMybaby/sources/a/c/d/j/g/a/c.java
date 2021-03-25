package a.c.d.j.g.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;

public class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f296a;

    public c(NumberPicker numberPicker) {
        this.f296a = numberPicker;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f296a.f3912e.selectAll();
            return;
        }
        this.f296a.f3912e.setSelection(0, 0);
        NumberPicker numberPicker = this.f296a;
        if (numberPicker != null) {
            String valueOf = String.valueOf(((TextView) view).getText());
            if (TextUtils.isEmpty(valueOf)) {
                numberPicker.w();
            } else {
                numberPicker.t(numberPicker.i(valueOf), true);
            }
        } else {
            throw null;
        }
    }
}
