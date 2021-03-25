package a.d.a.a.h.f;

import a.d.a.a.b.f;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

public final class r extends f {

    /* renamed from: c  reason: collision with root package name */
    public final k1 f1552c = new k1();

    public r(h hVar) {
        super(hVar);
    }

    public final void t() {
        f h = h();
        if (h.f1184c == null) {
            synchronized (h) {
                if (h.f1184c == null) {
                    k1 k1Var = new k1();
                    PackageManager packageManager = h.f1182a.getPackageManager();
                    String packageName = h.f1182a.getPackageName();
                    k1Var.f1523c = packageName;
                    k1Var.f1524d = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(h.f1182a.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    k1Var.f1521a = packageName;
                    k1Var.f1522b = str;
                    h.f1184c = k1Var;
                }
            }
        }
        k1 k1Var2 = h.f1184c;
        k1 k1Var3 = this.f1552c;
        if (!TextUtils.isEmpty(k1Var2.f1521a)) {
            k1Var3.f1521a = k1Var2.f1521a;
        }
        if (!TextUtils.isEmpty(k1Var2.f1522b)) {
            k1Var3.f1522b = k1Var2.f1522b;
        }
        if (!TextUtils.isEmpty(k1Var2.f1523c)) {
            k1Var3.f1523c = k1Var2.f1523c;
        }
        if (!TextUtils.isEmpty(k1Var2.f1524d)) {
            k1Var3.f1524d = k1Var2.f1524d;
        }
        f1 j = j();
        j.u();
        String str2 = j.f1494d;
        if (str2 != null) {
            this.f1552c.f1521a = str2;
        }
        j.u();
        String str3 = j.f1493c;
        if (str3 != null) {
            this.f1552c.f1522b = str3;
        }
    }
}
