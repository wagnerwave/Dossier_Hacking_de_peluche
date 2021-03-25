package a.c.d.m.i;

import a.c.d.r.j;
import a.c.d.s.e.d.d.a.c;
import a.c.d.s.e.d.d.b.c;
import android.app.ProgressDialog;
import android.view.View;
import com.cuatroochenta.miniland.model.MyBellyData;
import com.cuatroochenta.miniland.pregnancy.mama.MyBellyImageFormActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.add.MamaMyBellyAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.edit.MyBellyEditRequest;
import com.sozpic.miniland.R;
import java.util.Calendar;

public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyBellyImageFormActivity f504a;

    public class a implements a.c.d.s.e.d.d.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f505a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MyBellyData f506b;

        public a(ProgressDialog progressDialog, MyBellyData myBellyData) {
            this.f505a = progressDialog;
            this.f506b = myBellyData;
        }
    }

    public class b implements a.c.d.s.e.d.d.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f508a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MyBellyData f509b;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.s.e.d.d.a.b f511a;

            public a(a.c.d.s.e.d.d.a.b bVar) {
                this.f511a = bVar;
            }

            public void run() {
                if (this.f511a.f42a.booleanValue()) {
                    b.this.f508a.dismiss();
                    b.this.f509b.setId(this.f511a.f1038c);
                    b bVar = b.this;
                    MyBellyImageFormActivity.q(i.this.f504a, bVar.f509b);
                    return;
                }
                a.c.a.f.b.j0(i.this.f504a, this.f511a.f43b);
            }
        }

        public b(ProgressDialog progressDialog, MyBellyData myBellyData) {
            this.f508a = progressDialog;
            this.f509b = myBellyData;
        }

        public void l(a.c.d.s.e.d.d.a.b bVar) {
            i.this.f504a.runOnUiThread(new a(bVar));
        }
    }

    public i(MyBellyImageFormActivity myBellyImageFormActivity) {
        this.f504a = myBellyImageFormActivity;
    }

    public void onClick(View view) {
        MyBellyImageFormActivity myBellyImageFormActivity = this.f504a;
        StringBuilder sb = new StringBuilder();
        if (myBellyImageFormActivity.l == null) {
            sb.append(a.c.a.d.a.h(R.string.TR_FALTA_IMAGEN));
        }
        if (sb.toString().isEmpty()) {
            ProgressDialog progressDialog = new ProgressDialog(this.f504a);
            progressDialog.show();
            MyBellyImageFormActivity myBellyImageFormActivity2 = this.f504a;
            if (myBellyImageFormActivity2 != null) {
                MyBellyData myBellyData = new MyBellyData(-1L, myBellyImageFormActivity2.g.getText().toString(), myBellyImageFormActivity2.i.getText().toString(), j.j.format(Calendar.getInstance().getTime()), myBellyImageFormActivity2.l);
                if (this.f504a.getIntent().hasExtra("key_image_url")) {
                    myBellyData.setId(Long.valueOf(this.f504a.getIntent().getLongExtra("ARGS_MY_BELLY_ID", -1)));
                    MyBellyImageFormActivity myBellyImageFormActivity3 = this.f504a;
                    a aVar = new a(progressDialog, myBellyData);
                    if (myBellyImageFormActivity3 != null) {
                        new c.b(new MyBellyEditRequest(myBellyData), aVar).start();
                        return;
                    }
                    throw null;
                }
                MyBellyImageFormActivity myBellyImageFormActivity4 = this.f504a;
                b bVar = new b(progressDialog, myBellyData);
                if (myBellyImageFormActivity4 != null) {
                    new c.b(new MamaMyBellyAddRequest(myBellyData), bVar).start();
                    return;
                }
                throw null;
            }
            throw null;
        }
        a.c.a.f.b.j0(this.f504a, sb.toString());
    }
}
