package a.d.a.a.e;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.e.m.i0;
import a.d.a.a.e.r.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1238a = g.f1241a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f1239b = new d();

    static {
        int i = g.f1241a;
    }

    @Nullable
    public Intent a(Context context, int i, @Nullable String str) {
        if (i == 1 || i == 2) {
            if (context != null && b.W(context)) {
                return i0.c();
            }
            StringBuilder n = a.n("gcore_");
            n.append(f1238a);
            n.append("-");
            if (!TextUtils.isEmpty(str)) {
                n.append(str);
            }
            n.append("-");
            if (context != null) {
                n.append(context.getPackageName());
            }
            n.append("-");
            if (context != null) {
                try {
                    n.append(c.a(context).b(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return i0.a("com.google.android.gms", n.toString());
        } else if (i != 3) {
            return null;
        } else {
            return i0.b("com.google.android.gms");
        }
    }

    public int b(Context context, int i) {
        int e2 = g.e(context, i);
        boolean z = true;
        if (e2 != 18) {
            z = e2 == 1 ? g.f(context, "com.google.android.gms") : false;
        }
        if (z) {
            return 18;
        }
        return e2;
    }
}
