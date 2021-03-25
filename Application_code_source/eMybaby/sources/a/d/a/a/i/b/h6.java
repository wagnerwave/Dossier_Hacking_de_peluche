package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.a.a.a;
import a.d.a.a.e.q.c;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import java.net.MalformedURLException;
import java.net.URL;

public final /* synthetic */ class h6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final f6 f2243a;

    public h6(f6 f6Var) {
        this.f2243a = f6Var;
    }

    public final void run() {
        Pair pair;
        String str;
        z3 z3Var;
        NetworkInfo networkInfo;
        URL url;
        f6 f6Var = this.f2243a;
        f6Var.b();
        if (f6Var.k().x.b()) {
            f6Var.i().m.a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long a2 = f6Var.k().y.a();
        f6Var.k().y.b(a2 + 1);
        if (a2 >= 5) {
            f6Var.i().i.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            f6Var.k().x.a(true);
            return;
        }
        c5 c5Var = f6Var.f2563a;
        c5Var.f().b();
        c5.q(c5Var.n());
        q3 z = c5Var.z();
        z.u();
        String str2 = z.f2474c;
        k4 o = c5Var.o();
        o.b();
        if (((c) o.f2563a.n) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (o.m == null || elapsedRealtime >= o.o) {
                ka kaVar = o.f2563a.g;
                if (kaVar != null) {
                    o.o = kaVar.n(str2, q.f2467b) + elapsedRealtime;
                    try {
                        a.C0053a b2 = a.b(o.f2563a.f2123a);
                        String str3 = b2.f1170a;
                        o.m = str3;
                        o.n = b2.f1171b;
                        if (str3 == null) {
                            o.m = "";
                        }
                    } catch (Exception e2) {
                        o.i().m.b("Unable to get advertising id", e2);
                        o.m = "";
                    }
                    pair = new Pair(o.m, Boolean.valueOf(o.n));
                } else {
                    throw null;
                }
            } else {
                pair = new Pair(o.m, Boolean.valueOf(o.n));
            }
            if (!c5Var.g.x().booleanValue() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                z3Var = c5Var.i().m;
                str = "ADID unavailable to retrieve Deferred Deep Link. Skipping";
            } else {
                h7 n = c5Var.n();
                n.n();
                try {
                    networkInfo = ((ConnectivityManager) n.f2563a.f2123a.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (SecurityException unused) {
                    networkInfo = null;
                }
                if (!(networkInfo != null && networkInfo.isConnected())) {
                    z3Var = c5Var.i().i;
                    str = "Network is not available for Deferred Deep Link request. Skipping";
                } else {
                    v9 t = c5Var.t();
                    c5Var.z();
                    String str4 = (String) pair.first;
                    long a3 = c5Var.o().y.a() - 1;
                    if (t != null) {
                        try {
                            b.h(str4);
                            b.h(str2);
                            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{31049L, Integer.valueOf(t.z0())}), str4, str2, Long.valueOf(a3)});
                            if (str2.equals(t.f2563a.g.h("debug.deferred.deeplink", ""))) {
                                format = format.concat("&ddl_test=1");
                            }
                            url = new URL(format);
                        } catch (IllegalArgumentException | MalformedURLException e3) {
                            t.i().f.b("Failed to create BOW URL for Deferred Deep Link. exception", e3.getMessage());
                            url = null;
                        }
                        h7 n2 = c5Var.n();
                        b5 b5Var = new b5(c5Var);
                        n2.b();
                        n2.n();
                        b.k(url);
                        b.k(b5Var);
                        n2.f().w(new j7(n2, str2, url, b5Var));
                        return;
                    }
                    throw null;
                }
            }
            z3Var.a(str);
            return;
        }
        throw null;
    }
}
