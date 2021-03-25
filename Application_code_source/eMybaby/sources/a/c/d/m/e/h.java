package a.c.d.m.e;

import a.c.d.m.e.k.i;
import a.c.d.m.e.k.o;
import a.c.d.m.e.l.l;
import a.c.d.m.e.l.m;
import a.c.d.s.e.a.b.b.c;
import a.c.d.s.e.a.c.b.c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.delete.MedicalDataEntryDeleteRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.delete.UltrasoundDeleteRequest;
import com.sozpic.miniland.R;
import java.util.List;

public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f348a;

    public class a implements DialogInterface.OnClickListener {
        public a(h hVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            h.this.f348a.r();
            m mVar = (m) h.this.f348a.f3947e;
            List<UltrasoundPhoto> list = mVar.f;
            if (list != null && !list.isEmpty()) {
                ProgressDialog progressDialog = new ProgressDialog(mVar.getActivity());
                progressDialog.show();
                new c.a(new UltrasoundDeleteRequest(Long.valueOf(mVar.f.get(mVar.f426d.getCurrentItem()).getId())), new l(mVar, progressDialog)).start();
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c(h hVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            h.this.f348a.r();
            Fragment fragment = ((o) h.this.f348a.f3947e).f392a;
            if (fragment instanceof i) {
                i iVar = (i) fragment;
                a.c.d.m.e.k.a aVar = iVar.j;
                int i2 = aVar.j;
                MedicalDataEntry medicalDataEntry = (MedicalDataEntry) aVar.g();
                if (medicalDataEntry != null && i2 != -1) {
                    ProgressDialog progressDialog = new ProgressDialog(iVar.getActivity());
                    progressDialog.show();
                    MedicalDataEntryDeleteRequest medicalDataEntryDeleteRequest = new MedicalDataEntryDeleteRequest();
                    medicalDataEntryDeleteRequest.f4100a = Long.valueOf(medicalDataEntry.getId());
                    new c.a(medicalDataEntryDeleteRequest, new a.c.d.m.e.k.h(iVar, i2, progressDialog)).start();
                }
            }
        }
    }

    public h(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f348a = myPregnancyFragmentContainerActivity;
    }

    public void onClick(View view) {
        AlertDialog.Builder positiveButton;
        String h;
        DialogInterface.OnClickListener cVar;
        MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity = this.f348a;
        Fragment fragment = myPregnancyFragmentContainerActivity.f3947e;
        if (fragment instanceof m) {
            positiveButton = new AlertDialog.Builder(myPregnancyFragmentContainerActivity).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_ECOGRAFIA_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new b());
            h = a.c.a.d.a.h(R.string.TR_CANCEL);
            cVar = new a(this);
        } else if (fragment instanceof o) {
            positiveButton = new AlertDialog.Builder(myPregnancyFragmentContainerActivity).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_MEDICAL_DATA_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new d());
            h = a.c.a.d.a.h(R.string.TR_CANCEL);
            cVar = new c(this);
        } else {
            return;
        }
        positiveButton.setNegativeButton((CharSequence) h, cVar).show();
    }
}
