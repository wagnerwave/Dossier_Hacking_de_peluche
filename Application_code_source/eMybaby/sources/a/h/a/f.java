package a.h.a;

import a.c.a.d.a;
import a.c.a.f.e;
import android.app.Dialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.ListadoTermometroActivity;
import com.sozpic.miniland.R;

public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f3470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f3471b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ListadoTermometroActivity f3472c;

    public f(ListadoTermometroActivity listadoTermometroActivity, EditText editText, Dialog dialog) {
        this.f3472c = listadoTermometroActivity;
        this.f3470a = editText;
        this.f3471b = dialog;
    }

    public void onClick(View view) {
        Float f;
        try {
            f = Float.valueOf(this.f3470a.getText().toString());
        } catch (NumberFormatException e2) {
            e.c(e2.getMessage());
            f = Float.valueOf(0.0f);
        }
        if (f.floatValue() < 30.0f || f.floatValue() > 45.0f) {
            Toast.makeText(this.f3472c, String.format(a.i(R.string.TR_ERROR_TEMP_OUT_OF_RANGE), new Object[]{30, 45}), 0).show();
            return;
        }
        TextView textView = ListadoTermometroActivity.x;
        textView.setText(this.f3470a.getText().toString() + "ºC");
        this.f3472c.r = Float.valueOf(this.f3470a.getText().toString()).floatValue();
        ((InputMethodManager) this.f3472c.getSystemService("input_method")).hideSoftInputFromWindow(this.f3470a.getWindowToken(), 0);
        this.f3472c.f4442c.setVisibility(8);
        this.f3472c.f4443d.setVisibility(0);
        ListadoTermometroActivity.x.setBackgroundResource(R.drawable.boton_redondeado_blanco_vacio);
        this.f3471b.dismiss();
    }
}
