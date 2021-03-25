package a.d.a.a.i.b;

import a.d.a.a.e.q.f;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import androidx.recyclerview.widget.RecyclerView;

public final class w3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2583a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2584b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2585c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f2586d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f2587e;
    public final /* synthetic */ x3 f;

    public w3(x3 x3Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f = x3Var;
        this.f2583a = i;
        this.f2584b = str;
        this.f2585c = obj;
        this.f2586d = obj2;
        this.f2587e = obj3;
    }

    public final void run() {
        SharedPreferences.Editor editor;
        char c2;
        x3 x3Var;
        k4 o = this.f.f2563a.o();
        if (!o.r()) {
            this.f.v(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        x3 x3Var2 = this.f;
        boolean z = true;
        if (x3Var2.f2617c == 0) {
            ka kaVar = x3Var2.f2563a.g;
            if (kaVar.f2332d == null) {
                synchronized (kaVar) {
                    if (kaVar.f2332d == null) {
                        ApplicationInfo applicationInfo = kaVar.f2563a.f2123a.getApplicationInfo();
                        String a2 = f.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            kaVar.f2332d = Boolean.valueOf(str != null && str.equals(a2));
                        }
                        if (kaVar.f2332d == null) {
                            kaVar.f2332d = Boolean.TRUE;
                            kaVar.i().f.a("My process not in the list of running processes");
                        }
                    }
                }
            }
            if (kaVar.f2332d.booleanValue()) {
                x3Var = this.f;
                c2 = 'C';
            } else {
                x3Var = this.f;
                c2 = 'c';
            }
            x3Var.f2617c = c2;
        }
        x3 x3Var3 = this.f;
        if (x3Var3.f2618d < 0) {
            x3Var3.f2618d = 31049;
        }
        char charAt = "01VDIWEA?".charAt(this.f2583a);
        x3 x3Var4 = this.f;
        char c3 = x3Var4.f2617c;
        long j = x3Var4.f2618d;
        String u = x3.u(true, this.f2584b, this.f2585c, this.f2586d, this.f2587e);
        StringBuilder sb = new StringBuilder(String.valueOf(u).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c3);
        sb.append(j);
        sb.append(":");
        sb.append(u);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.f2584b.substring(0, 1024);
        }
        n4 n4Var = o.f2316d;
        n4Var.f2402e.b();
        if (n4Var.f2402e.v().getLong(n4Var.f2398a, 0) == 0) {
            n4Var.a();
        }
        if (sb2 == null) {
            sb2 = "";
        }
        long j2 = n4Var.f2402e.v().getLong(n4Var.f2399b, 0);
        if (j2 <= 0) {
            editor = n4Var.f2402e.v().edit();
            editor.putString(n4Var.f2400c, sb2);
            editor.putLong(n4Var.f2399b, 1);
        } else {
            long j3 = j2 + 1;
            if ((n4Var.f2402e.e().w0().nextLong() & RecyclerView.FOREVER_NS) >= RecyclerView.FOREVER_NS / j3) {
                z = false;
            }
            editor = n4Var.f2402e.v().edit();
            if (z) {
                editor.putString(n4Var.f2400c, sb2);
            }
            editor.putLong(n4Var.f2399b, j3);
        }
        editor.apply();
    }
}
