package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.f.b;
import a.c.d.r.i;
import a.c.d.s.e.d.b.a.c;
import a.c.d.s.e.d.b.b.b;
import android.app.ProgressDialog;
import android.view.View;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.add.MamaFetalMovAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.edit.FetalMovementEditRequest;
import com.sozpic.miniland.R;
import java.util.Calendar;

public class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f608a;

    public j(e eVar) {
        this.f608a = eVar;
    }

    public void onClick(View view) {
        e eVar = this.f608a;
        if (eVar.r == null) {
            b.h0(eVar.getActivity(), a.h(R.string.TR_RELLENA_LOS_CAMPOS_SOLICITADOS), a.h(R.string.TR_ACEPTAR));
            return;
        }
        boolean booleanValue = ((Boolean) eVar.o.getTag()).booleanValue();
        boolean booleanValue2 = ((Boolean) this.f608a.p.getTag()).booleanValue();
        e eVar2 = this.f608a;
        if (eVar2.u) {
            a.c.d.r.j.j.format(eVar2.r.getTime());
            if (eVar2 != null) {
                ProgressDialog progressDialog = new ProgressDialog(eVar2.getActivity());
                progressDialog.show();
                MeasureWithTwoValues measureWithTwoValues = new MeasureWithTwoValues(-1, (Boolean) eVar2.o.getTag(), (Boolean) eVar2.p.getTag(), i.d(Calendar.getInstance().getTime()), a.c.d.r.j.j.format(eVar2.r.getTime()));
                measureWithTwoValues.setId(eVar2.s.getId());
                new b.a(new FetalMovementEditRequest(measureWithTwoValues), new d(eVar2, progressDialog, booleanValue, booleanValue2)).start();
                return;
            }
            throw null;
        }
        Boolean valueOf = Boolean.valueOf(booleanValue);
        Boolean valueOf2 = Boolean.valueOf(booleanValue2);
        String format = a.c.d.r.j.j.format(this.f608a.r.getTime());
        if (eVar2 != null) {
            ProgressDialog progressDialog2 = new ProgressDialog(eVar2.getActivity());
            progressDialog2.show();
            new c.a(new MamaFetalMovAddRequest(format, valueOf.booleanValue(), valueOf2.booleanValue()), new a(eVar2, valueOf, valueOf2, format, progressDialog2)).start();
            return;
        }
        throw null;
    }
}
