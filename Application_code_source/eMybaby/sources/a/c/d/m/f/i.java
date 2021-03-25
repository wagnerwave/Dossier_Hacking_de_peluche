package a.c.d.m.f;

import a.c.d.s.e.a.a.b.b;
import a.c.d.s.e.a.a.b.c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.delete.BabyDiaryEntryDeleteRequest;
import com.sozpic.miniland.R;

public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f442a;

    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a.c.d.m.f.i$a$a  reason: collision with other inner class name */
        public class C0025a implements c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ProgressDialog f444a;

            public C0025a(ProgressDialog progressDialog) {
                this.f444a = progressDialog;
            }
        }

        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ProgressDialog progressDialog = new ProgressDialog(i.this.f442a);
            progressDialog.show();
            n a2 = i.this.f442a.k.a();
            new b.a(new BabyDiaryEntryDeleteRequest(Long.valueOf(((BabyDiaryEntry) a2.getItem(a2.f)).getId())), new C0025a(progressDialog)).start();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b(i iVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public i(BabyDiaryActivity babyDiaryActivity) {
        this.f442a = babyDiaryActivity;
    }

    public void onClick(View view) {
        new AlertDialog.Builder(this.f442a).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new b(this)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_ENTRADA_DIARIO_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new a()).show();
    }
}
