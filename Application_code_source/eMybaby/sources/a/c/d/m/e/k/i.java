package a.c.d.m.e.k;

import a.c.a.d.a;
import a.c.d.s.e.a.b.d.d;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.list.MedicalDataListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Collections;

public class i extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public ListView f379a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f380b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f381c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f382d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f383e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public a j;

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_medical_data_entries, viewGroup, false);
        this.f379a = (ListView) inflate.findViewById(R.id.medical_data_entries_list_entries);
        this.f380b = (TextView) inflate.findViewById(R.id.medical_data_entries_label_fl);
        this.f381c = (TextView) inflate.findViewById(R.id.medical_data_entries_label_hc);
        this.f382d = (TextView) inflate.findViewById(R.id.medical_data_entries_label_ac);
        this.f383e = (TextView) inflate.findViewById(R.id.medical_data_entries_label_efw);
        this.f = (TextView) inflate.findViewById(R.id.medical_data_entries_label_longitud_femur);
        this.g = (TextView) inflate.findViewById(R.id.medical_data_entries_label_estimacion_peso);
        this.h = (TextView) inflate.findViewById(R.id.medical_data_entries_label_perimetro_craneal);
        this.i = (TextView) inflate.findViewById(R.id.medical_data_entries_label_perimetro_abdominal);
        this.f380b.setText(a.h(R.string.TR_FL));
        this.f381c.setText(a.h(R.string.TR_HC));
        this.f382d.setText(a.h(R.string.TR_AC));
        this.f383e.setText(a.h(R.string.TR_EFW));
        this.f.setText(a.h(R.string.TR_LONGITUD_FEMUR).replace(" ", "\n"));
        this.g.setText(a.h(R.string.TR_ESTIMACION_PESO).replace(" ", "\n"));
        this.h.setText(a.h(R.string.TR_PERIMETRO_CRANEAL).replace(" ", "\n"));
        this.i.setText(a.h(R.string.TR_PERIMETRO_ABDOMINAL).replace(" ", "\n"));
        a aVar = new a();
        this.j = aVar;
        c cVar = new c(this);
        aVar.f804b = true;
        aVar.f805c = cVar;
        Collections.sort(aVar.f803a, cVar);
        this.j.g = new d(this);
        this.j.h = new e(this);
        this.f379a.setAdapter(this.j);
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
        MedicalDataListRequest medicalDataListRequest = new MedicalDataListRequest();
        medicalDataListRequest.f4106a = AppMiniland.f().i().getId();
        medicalDataListRequest.f4107b = ((AppMiniland) a.c.a.a.f).i().getPass();
        ((AppMiniland) a.c.a.a.f).i().getPass();
        ((AppMiniland) a.c.a.a.f).i().getCorreo();
        new d.a(medicalDataListRequest, new b(this, progressDialog)).start();
        return inflate;
    }
}
