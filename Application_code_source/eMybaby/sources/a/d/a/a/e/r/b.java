package a.d.a.a.e.r;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1443a;

    public b(Context context) {
        this.f1443a = context;
    }

    public ApplicationInfo a(String str, int i) {
        return this.f1443a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo b(String str, int i) {
        return this.f1443a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean c() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f1443a);
        }
        if (!a.c.a.f.b.O() || (nameForUid = this.f1443a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f1443a.getPackageManager().isInstantApp(nameForUid);
    }
}
