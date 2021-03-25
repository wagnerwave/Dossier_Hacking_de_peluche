package a.c.d;

import android.app.ProgressDialog;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import d.a.a.e;

public class c extends FragmentActivity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f54a;

    public void a() {
        super.onBackPressed();
    }

    public void b() {
    }

    public void o() {
        ProgressDialog progressDialog = this.f54a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f54a.dismiss();
        }
    }

    public void onResume() {
        super.onResume();
        e.d(this, getString(R.string.hockeyAppId), new b(this));
    }

    public void p(String str, boolean z) {
        if (!isFinishing()) {
            ProgressDialog progressDialog = this.f54a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                try {
                    ProgressDialog progressDialog2 = new ProgressDialog(this);
                    this.f54a = progressDialog2;
                    progressDialog2.setMessage(str);
                    this.f54a.setCancelable(z);
                    this.f54a.show();
                } catch (Exception e2) {
                    a.c.a.f.e.e(e2.getLocalizedMessage());
                }
            }
        }
    }
}
