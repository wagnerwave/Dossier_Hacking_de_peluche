package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.f.b;
import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.d.c.a.c;
import a.c.d.s.e.d.c.b.b;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.EditText;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.add.MamaFundHeightAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.edit.FundalHeightEditRequest;
import com.sozpic.miniland.R;

public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f664b;

    public w(s sVar, EditText editText) {
        this.f664b = sVar;
        this.f663a = editText;
    }

    public void onClick(View view) {
        if (a.j(this.f663a.getText().toString()) || this.f664b.q == null) {
            b.h0(this.f664b.getActivity(), a.h(R.string.TR_RELLENA_LOS_CAMPOS_SOLICITADOS), a.h(R.string.TR_ACEPTAR));
            return;
        }
        String obj = this.f663a.getText().toString();
        s sVar = this.f664b;
        boolean z = sVar.t;
        Integer valueOf = Integer.valueOf(obj);
        if (z) {
            j.j.format(this.f664b.q.getTime());
            if (sVar != null) {
                ProgressDialog progressDialog = new ProgressDialog(sVar.getActivity());
                progressDialog.show();
                new b.a(new FundalHeightEditRequest(sVar.q.getTime(), i.b(sVar.q.getTime()), valueOf.intValue(), sVar.r.getIdCrecimiento().longValue()), new z(sVar, progressDialog, valueOf)).start();
                return;
            }
            throw null;
        }
        int intValue = valueOf.intValue();
        String format = j.j.format(this.f664b.q.getTime());
        if (sVar != null) {
            sVar.C(a.h(R.string.TR_GUARDANDO_ALTURA_UTERO), false);
            new c.a(new MamaFundHeightAddRequest(format, Integer.valueOf(intValue)), sVar).start();
            return;
        }
        throw null;
    }
}
