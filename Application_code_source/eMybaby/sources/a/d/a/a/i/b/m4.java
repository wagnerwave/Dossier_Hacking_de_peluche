package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

public final class m4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2365a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2366b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2367c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2368d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k4 f2369e;

    public m4(k4 k4Var, String str, boolean z) {
        this.f2369e = k4Var;
        b.h(str);
        this.f2365a = str;
        this.f2366b = z;
    }

    @WorkerThread
    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.f2369e.v().edit();
        edit.putBoolean(this.f2365a, z);
        edit.apply();
        this.f2368d = z;
    }

    @WorkerThread
    public final boolean b() {
        if (!this.f2367c) {
            this.f2367c = true;
            this.f2368d = this.f2369e.v().getBoolean(this.f2365a, this.f2366b);
        }
        return this.f2368d;
    }
}
