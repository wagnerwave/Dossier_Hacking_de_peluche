package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.e.q.c;
import android.content.SharedPreferences;
import androidx.recyclerview.widget.RecyclerView;
import java.util.UUID;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u0 f1572b;

    public w0(u0 u0Var, String str, long j, v0 v0Var) {
        this.f1572b = u0Var;
        b.h(str);
        b.d(j > 0);
        this.f1571a = str;
    }

    public final void a(String str) {
        if (this.f1572b.f1566c.getLong(String.valueOf(this.f1571a).concat(":start"), 0) == 0) {
            if (((c) this.f1572b.f1490a.f1505c) != null) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor edit = this.f1572b.f1566c.edit();
                edit.remove(b());
                edit.remove(c());
                edit.putLong(String.valueOf(this.f1571a).concat(":start"), currentTimeMillis);
                edit.commit();
            } else {
                throw null;
            }
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.f1572b.f1566c.getLong(b(), 0);
            if (j <= 0) {
                SharedPreferences.Editor edit2 = this.f1572b.f1566c.edit();
                edit2.putString(c(), str);
                edit2.putLong(b(), 1);
                edit2.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j2;
            SharedPreferences.Editor edit3 = this.f1572b.f1566c.edit();
            if (z) {
                edit3.putString(c(), str);
            }
            edit3.putLong(b(), j2);
            edit3.apply();
        }
    }

    public final String b() {
        return String.valueOf(this.f1571a).concat(":count");
    }

    public final String c() {
        return String.valueOf(this.f1571a).concat(":value");
    }
}
