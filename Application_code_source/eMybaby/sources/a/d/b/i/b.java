package a.d.b.i;

import a.d.b.i.c;
import android.content.Context;
import androidx.annotation.NonNull;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public d f2778a;

    public b(Context context) {
        d dVar;
        synchronized (d.class) {
            if (d.f2784b == null) {
                d.f2784b = new d(context);
            }
            dVar = d.f2784b;
        }
        this.f2778a = dVar;
    }

    @NonNull
    public c.a a(@NonNull String str) {
        boolean a2;
        long currentTimeMillis = System.currentTimeMillis();
        boolean a3 = this.f2778a.a(str, currentTimeMillis);
        d dVar = this.f2778a;
        synchronized (dVar) {
            a2 = dVar.a("fire-global", currentTimeMillis);
        }
        if (a3 && a2) {
            return c.a.COMBINED;
        }
        if (a2) {
            return c.a.GLOBAL;
        }
        return a3 ? c.a.SDK : c.a.NONE;
    }
}
