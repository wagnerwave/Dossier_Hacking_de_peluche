package a.d.a.a.i.b;

import a.d.a.a.a.a.a;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.u9;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class u8 extends m9 {

    /* renamed from: d  reason: collision with root package name */
    public String f2551d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2552e;
    public long f;

    public u8(o9 o9Var) {
        super(o9Var);
    }

    public final boolean p() {
        return false;
    }

    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> s(String str, e eVar) {
        return (!u9.b() || !this.f2563a.g.o(q.Q0) || eVar.j()) ? u(str) : new Pair<>("", Boolean.FALSE);
    }

    @WorkerThread
    @Deprecated
    public final String t(String str) {
        b();
        String str2 = (String) u(str).first;
        MessageDigest y0 = v9.y0();
        if (y0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, y0.digest(str2.getBytes()))});
    }

    @WorkerThread
    @NonNull
    @Deprecated
    public final Pair<String, Boolean> u(String str) {
        b();
        if (((c) this.f2563a.n) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f2551d != null && elapsedRealtime < this.f) {
                return new Pair<>(this.f2551d, Boolean.valueOf(this.f2552e));
            }
            ka kaVar = this.f2563a.g;
            if (kaVar != null) {
                this.f = elapsedRealtime + kaVar.n(str, q.f2467b);
                try {
                    a.C0053a b2 = a.b(this.f2563a.f2123a);
                    String str2 = b2.f1170a;
                    this.f2551d = str2;
                    this.f2552e = b2.f1171b;
                    if (str2 == null) {
                        this.f2551d = "";
                    }
                } catch (Exception e2) {
                    i().m.b("Unable to get advertising id", e2);
                    this.f2551d = "";
                }
                return new Pair<>(this.f2551d, Boolean.valueOf(this.f2552e));
            }
            throw null;
        }
        throw null;
    }
}
