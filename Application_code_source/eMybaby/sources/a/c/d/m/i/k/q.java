package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.f.b;
import a.c.d.r.j;
import a.c.d.s.e.d.a.a.c;
import a.c.d.s.e.d.a.b.b;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.add.MamaBloodPressureAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.edit.BloodPressureEditRequest;
import com.sozpic.miniland.R;

public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f641c;

    public q(k kVar, EditText editText, EditText editText2) {
        this.f641c = kVar;
        this.f639a = editText;
        this.f640b = editText2;
    }

    public void onClick(View view) {
        if (a.j(this.f639a.getText().toString()) || a.j(this.f640b.getText().toString()) || this.f641c.o == null) {
            b.h0(this.f641c.getActivity(), a.h(R.string.TR_RELLENA_LOS_CAMPOS_SOLICITADOS), a.h(R.string.TR_ACEPTAR));
            return;
        }
        String obj = this.f639a.getText().toString();
        String obj2 = this.f640b.getText().toString();
        k kVar = this.f641c;
        if (!kVar.u) {
            int intValue = Integer.valueOf(obj).intValue();
            int intValue2 = Integer.valueOf(obj2).intValue();
            if (this.f641c != null) {
                String g = a.g((String) null);
                String format = j.j.format(this.f641c.o.getTime());
                if (kVar != null) {
                    kVar.C(a.h(R.string.TR_GUARDANDO_MEDIDA_TENSION_ARTERIAL), false);
                    new c.a(new MamaBloodPressureAddRequest(format, g, intValue, intValue2), kVar).start();
                    return;
                }
                throw null;
            }
            throw null;
        } else if (kVar != null) {
            ProgressDialog progressDialog = new ProgressDialog(kVar.getActivity());
            progressDialog.show();
            n nVar = new n(kVar, progressDialog);
            MeasureWithTwoValues<Integer, Integer> E = kVar.E();
            E.setId(kVar.p.getId());
            new b.a(new BloodPressureEditRequest(E), nVar).start();
        } else {
            throw null;
        }
    }
}
