package a.c.d.m.f;

import a.c.d.r.i;
import a.c.d.r.j;
import a.c.d.s.e.a.a.a.b;
import a.c.d.s.e.a.a.a.c;
import a.c.d.s.e.a.a.c.b;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.add.BabyDiaryEntryDataAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.edit.BabyDiaryEditRequest;
import com.sozpic.miniland.R;
import java.util.Date;

public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FormBabyDiaryEntryActivity f463a;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BabyDiaryEntry f465b;

        public a(ProgressDialog progressDialog, BabyDiaryEntry babyDiaryEntry) {
            this.f464a = progressDialog;
            this.f465b = babyDiaryEntry;
        }
    }

    public class b implements a.c.d.s.e.a.a.c.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BabyDiaryEntry f468b;

        public b(ProgressDialog progressDialog, BabyDiaryEntry babyDiaryEntry) {
            this.f467a = progressDialog;
            this.f468b = babyDiaryEntry;
        }
    }

    public s(FormBabyDiaryEntryActivity formBabyDiaryEntryActivity) {
        this.f463a = formBabyDiaryEntryActivity;
    }

    public void onClick(View view) {
        FormBabyDiaryEntryActivity formBabyDiaryEntryActivity = this.f463a;
        String h = (formBabyDiaryEntryActivity.k != null || !formBabyDiaryEntryActivity.g.getText().toString().isEmpty()) ? null : a.c.a.d.a.h(R.string.TR_DEBES_APORTAR_AL_MENOS_UNA_FOTO_O_Y_COMENTARIO);
        if (a.c.a.d.a.j(h)) {
            ProgressDialog progressDialog = new ProgressDialog(this.f463a);
            progressDialog.show();
            FormBabyDiaryEntryActivity formBabyDiaryEntryActivity2 = this.f463a;
            BabyDiaryEntry babyDiaryEntry = formBabyDiaryEntryActivity2.m;
            if (babyDiaryEntry == null) {
                babyDiaryEntry = new BabyDiaryEntry();
            }
            babyDiaryEntry.setPhotoPath(formBabyDiaryEntryActivity2.k);
            babyDiaryEntry.setBody(formBabyDiaryEntryActivity2.g.getText().toString());
            Date date = babyDiaryEntry.getDate();
            babyDiaryEntry.setTitle(i.d(date) + "\n" + j.f.format(date));
            babyDiaryEntry.setWeek((int) i.c(babyDiaryEntry.getDate()));
            FormBabyDiaryEntryActivity formBabyDiaryEntryActivity3 = this.f463a;
            String action = formBabyDiaryEntryActivity3.getIntent().getAction() == null ? "ACTION_CREATE" : formBabyDiaryEntryActivity3.getIntent().getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1763616987) {
                if (hashCode == -529162637 && action.equals("ACTION_EDIT")) {
                    c2 = 1;
                }
            } else if (action.equals("ACTION_CREATE")) {
                c2 = 0;
            }
            if (c2 == 0) {
                FormBabyDiaryEntryActivity formBabyDiaryEntryActivity4 = this.f463a;
                a aVar = new a(progressDialog, babyDiaryEntry);
                if (formBabyDiaryEntryActivity4 != null) {
                    new b.C0045b(new BabyDiaryEntryDataAddRequest(babyDiaryEntry), aVar).start();
                    return;
                }
                throw null;
            } else if (c2 != 1) {
                progressDialog.dismiss();
                FormBabyDiaryEntryActivity.q(this.f463a, babyDiaryEntry);
            } else {
                babyDiaryEntry.setId(this.f463a.getIntent().getLongExtra("ARGS_DIARY_ID", -1));
                FormBabyDiaryEntryActivity formBabyDiaryEntryActivity5 = this.f463a;
                b bVar = new b(progressDialog, babyDiaryEntry);
                if (formBabyDiaryEntryActivity5 != null) {
                    new b.a(new BabyDiaryEditRequest(babyDiaryEntry), bVar).start();
                    return;
                }
                throw null;
            }
        } else {
            FormBabyDiaryEntryActivity formBabyDiaryEntryActivity6 = this.f463a;
            if (formBabyDiaryEntryActivity6 != null) {
                new AlertDialog.Builder(formBabyDiaryEntryActivity6).setMessage((CharSequence) h).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_OK), (DialogInterface.OnClickListener) new v(formBabyDiaryEntryActivity6)).show();
                return;
            }
            throw null;
        }
    }
}
