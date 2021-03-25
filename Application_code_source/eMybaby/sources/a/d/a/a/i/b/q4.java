package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

public final class q4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2477a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2478b;

    /* renamed from: c  reason: collision with root package name */
    public String f2479c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k4 f2480d;

    public q4(k4 k4Var, String str) {
        this.f2480d = k4Var;
        b.h(str);
        this.f2477a = str;
    }

    @WorkerThread
    public final String a() {
        if (!this.f2478b) {
            this.f2478b = true;
            this.f2479c = this.f2480d.v().getString(this.f2477a, (String) null);
        }
        return this.f2479c;
    }

    @WorkerThread
    public final void b(String str) {
        SharedPreferences.Editor edit = this.f2480d.v().edit();
        edit.putString(this.f2477a, str);
        edit.apply();
        this.f2479c = str;
    }
}
