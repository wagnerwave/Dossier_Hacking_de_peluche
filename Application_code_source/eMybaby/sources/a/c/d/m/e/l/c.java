package a.c.d.m.e.l;

import a.c.d.s.e.a.c.a.c;
import a.c.d.s.e.a.c.c.c;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.add.UltrasoundAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.edit.UltrasoundEditRequest;
import com.sozpic.miniland.R;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UltrasoundFormActivity f404a;

    public class a implements a.c.d.s.e.a.c.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f405a;

        /* renamed from: a.c.d.m.e.l.c$a$a  reason: collision with other inner class name */
        public class C0024a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.s.e.a.c.a.b f407a;

            public C0024a(a.c.d.s.e.a.c.a.b bVar) {
                this.f407a = bVar;
            }

            public void run() {
                a.this.f405a.dismiss();
                if (this.f407a.f42a.booleanValue()) {
                    UltrasoundFormActivity.q(c.this.f404a, this.f407a.f936c);
                } else {
                    a.c.a.f.b.j0(c.this.f404a, this.f407a.f43b);
                }
            }
        }

        public a(ProgressDialog progressDialog) {
            this.f405a = progressDialog;
        }

        public void a(a.c.d.s.e.a.c.a.b bVar) {
            c.this.f404a.runOnUiThread(new C0024a(bVar));
        }
    }

    public class b implements a.c.d.s.e.a.c.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f409a;

        public b(ProgressDialog progressDialog) {
            this.f409a = progressDialog;
        }
    }

    public c(UltrasoundFormActivity ultrasoundFormActivity) {
        this.f404a = ultrasoundFormActivity;
    }

    public void onClick(View view) {
        UltrasoundFormActivity ultrasoundFormActivity = this.f404a;
        StringBuilder sb = new StringBuilder();
        if (a.c.a.d.a.j(ultrasoundFormActivity.m)) {
            sb.append(a.c.a.d.a.h(R.string.TR_FALTA_IMAGEN));
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            ProgressDialog progressDialog = new ProgressDialog(this.f404a);
            progressDialog.show();
            String action = this.f404a.getIntent().getAction();
            if (action == null) {
                action = "ACTION_CREATE";
            }
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
                UltrasoundFormActivity ultrasoundFormActivity2 = this.f404a;
                a aVar = new a(progressDialog);
                new c.b(new UltrasoundAddRequest(ultrasoundFormActivity2.r()), aVar).start();
            } else if (c2 != 1) {
                UltrasoundFormActivity.q(this.f404a, -1);
            } else {
                UltrasoundFormActivity ultrasoundFormActivity3 = this.f404a;
                b bVar = new b(progressDialog);
                long j = ultrasoundFormActivity3.n;
                UltrasoundPhoto r = ultrasoundFormActivity3.r();
                r.setId(j);
                new c.b(new UltrasoundEditRequest(r), bVar).start();
            }
        } else {
            UltrasoundFormActivity ultrasoundFormActivity4 = this.f404a;
            if (ultrasoundFormActivity4 != null) {
                new AlertDialog.Builder(ultrasoundFormActivity4).setMessage((CharSequence) sb2).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_OK), (DialogInterface.OnClickListener) new f(ultrasoundFormActivity4)).show();
                return;
            }
            throw null;
        }
    }
}
