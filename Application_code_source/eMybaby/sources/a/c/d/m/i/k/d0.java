package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.f.b;
import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.d.e.a.c;
import a.c.d.s.e.d.e.c.c;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;
import com.cuatroochenta.miniland.model.MeasurePregnancyMama;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.add.MamaWeightAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.edit.MamaWeightEditRequest;
import com.sozpic.miniland.R;

public class d0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f552a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h0 f553b;

    public d0(h0 h0Var, EditText editText) {
        this.f553b = h0Var;
        this.f552a = editText;
    }

    public void onClick(View view) {
        if (a.j(this.f552a.getText().toString()) || this.f553b.w == null) {
            b.h0(this.f553b.getActivity(), a.h(R.string.TR_RELLENA_LOS_CAMPOS_SOLICITADOS), a.h(R.string.TR_ACEPTAR));
            return;
        }
        String obj = this.f552a.getText().toString();
        h0 h0Var = this.f553b;
        boolean z = h0Var.B;
        Float valueOf = Float.valueOf(obj);
        if (z) {
            j.n.format(this.f553b.w.getTime());
            if (h0Var != null) {
                ProgressDialog progressDialog = new ProgressDialog(h0Var.getActivity());
                progressDialog.show();
                new c.a(new MamaWeightEditRequest(h0Var.w.getTime(), i.d(h0Var.z.getDate()), valueOf.floatValue(), h0Var.z.getIdCrecimiento().longValue()), new g0(h0Var, progressDialog, valueOf)).start();
                return;
            }
            throw null;
        }
        float floatValue = valueOf.floatValue();
        j.f.format(this.f553b.w.getTime());
        if (h0Var != null) {
            MeasurePregnancyMama measurePregnancyMama = new MeasurePregnancyMama();
            measurePregnancyMama.setValue(floatValue);
            measurePregnancyMama.setDate(h0Var.w.getTime());
            measurePregnancyMama.setTitle(i.d(measurePregnancyMama.getDate()));
            measurePregnancyMama.setIdCrecimiento(-1L);
            ProgressDialog progressDialog2 = new ProgressDialog(h0Var.getActivity());
            progressDialog2.show();
            new c.a(new MamaWeightAddRequest(measurePregnancyMama.getValue(), j.j.format(measurePregnancyMama.getDate())), new c0(h0Var, measurePregnancyMama, progressDialog2)).start();
            return;
        }
        throw null;
    }
}
