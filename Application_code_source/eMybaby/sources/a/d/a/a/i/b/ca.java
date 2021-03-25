package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;

public final class ca {

    /* renamed from: a  reason: collision with root package name */
    public final c5 f2141a;

    public ca(c5 c5Var) {
        this.f2141a = c5Var;
    }

    @WorkerThread
    public final void a(String str, Bundle bundle) {
        String str2;
        this.f2141a.f().b();
        if (!this.f2141a.d()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f2141a.o().A.b(str2);
                o4 o4Var = this.f2141a.o().B;
                if (((c) this.f2141a.n) != null) {
                    o4Var.b(System.currentTimeMillis());
                    return;
                }
                throw null;
            }
        }
    }

    public final boolean b() {
        if (!c()) {
            return false;
        }
        if (((c) this.f2141a.n) == null) {
            throw null;
        } else if (System.currentTimeMillis() - this.f2141a.o().B.a() > this.f2141a.g.n((String) null, q.M0)) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean c() {
        return this.f2141a.o().B.a() > 0;
    }
}
