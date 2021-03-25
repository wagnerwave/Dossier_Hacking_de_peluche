package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

public final class o4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2422a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2423b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2424c;

    /* renamed from: d  reason: collision with root package name */
    public long f2425d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k4 f2426e;

    public o4(k4 k4Var, String str, long j) {
        this.f2426e = k4Var;
        b.h(str);
        this.f2422a = str;
        this.f2423b = j;
    }

    @WorkerThread
    public final long a() {
        if (!this.f2424c) {
            this.f2424c = true;
            this.f2425d = this.f2426e.v().getLong(this.f2422a, this.f2423b);
        }
        return this.f2425d;
    }

    @WorkerThread
    public final void b(long j) {
        SharedPreferences.Editor edit = this.f2426e.v().edit();
        edit.putLong(this.f2422a, j);
        edit.apply();
        this.f2425d = j;
    }
}
