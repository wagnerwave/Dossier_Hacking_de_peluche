package a.c.d.d;

import a.c.d.r.h;
import a.c.d.s.g.b;
import a.c.d.s.g.e;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.R;

public class d extends h implements a.c.d.s.g.a, h.b {
    public ProgressDialog i;
    public a j;
    public b k;
    public int l;
    public Activity m;

    public interface a {
        void l(String str);
    }

    public d(@NonNull Activity activity, a aVar, Bundle bundle) {
        super(activity, (h.b) null, bundle);
        this.f = this;
        this.j = aVar;
        this.m = activity;
    }

    public d(@NonNull Activity activity, h.b bVar, Bundle bundle) {
        super(activity, bVar, bundle);
    }

    public void c(String str) {
        ProgressDialog progressDialog = new ProgressDialog(this.m);
        this.i = progressDialog;
        progressDialog.setCancelable(false);
        this.i.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
        this.i.setIndeterminate(true);
        this.i.show();
        if (this.k == null) {
            this.k = new b();
        }
        this.k.f1146a = str;
        String str2 = null;
        int i2 = this.l;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            str2 = "https://emybaby.com/api/album.php";
        }
        new e.b(this.k, this).start();
    }

    public String g() {
        return a.c.a.d.a.h(R.string.TR_SELECCIONAR_IMAGEN_DE);
    }

    public void i() {
    }

    public void t(int i2, b bVar) {
        this.l = i2;
        if (i2 == 0) {
            this.k = bVar;
            a();
        }
    }

    public d(@NonNull Fragment fragment, a aVar, Bundle bundle) {
        super(fragment, (h.b) null, bundle);
        this.f = this;
        this.j = aVar;
        this.m = fragment.getActivity();
    }
}
