package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

public final class n4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2398a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2399b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2400c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2401d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k4 f2402e;

    public n4(k4 k4Var, String str, long j, j4 j4Var) {
        this.f2402e = k4Var;
        b.h(str);
        b.d(j > 0);
        this.f2398a = str.concat(":start");
        this.f2399b = str.concat(":count");
        this.f2400c = str.concat(":value");
        this.f2401d = j;
    }

    @WorkerThread
    public final void a() {
        this.f2402e.b();
        if (((c) this.f2402e.f2563a.n) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor edit = this.f2402e.v().edit();
            edit.remove(this.f2399b);
            edit.remove(this.f2400c);
            edit.putLong(this.f2398a, currentTimeMillis);
            edit.apply();
            return;
        }
        throw null;
    }
}
