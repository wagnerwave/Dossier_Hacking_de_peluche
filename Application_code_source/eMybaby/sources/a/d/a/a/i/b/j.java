package a.d.a.a.i.b;

import a.c.a.f.b;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzam;
import java.util.Iterator;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f2284a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2285b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2286c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2287d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2288e;
    public final zzam f;

    public j(c5 c5Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        b.h(str2);
        b.h(str3);
        this.f2284a = str2;
        this.f2285b = str3;
        this.f2286c = TextUtils.isEmpty(str) ? null : str;
        this.f2287d = j;
        this.f2288e = j2;
        if (j2 != 0 && j2 > j) {
            c5Var.i().i.b("Event created with reverse previous/current timestamps. appId", x3.s(str2));
        }
        if (!bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    c5Var.i().f.a("Param name can't be null");
                } else {
                    Object D = c5Var.t().D(str4, bundle2.get(str4));
                    if (D == null) {
                        c5Var.i().i.b("Param value can't be null", c5Var.u().x(str4));
                    } else {
                        c5Var.t().I(bundle2, str4, D);
                    }
                }
                it.remove();
            }
            zzam = new zzam(bundle2);
        } else {
            zzam = new zzam(new Bundle());
        }
        this.f = zzam;
    }

    public final j a(c5 c5Var, long j) {
        return new j(c5Var, this.f2286c, this.f2284a, this.f2285b, this.f2287d, j, this.f);
    }

    public final String toString() {
        String str = this.f2284a;
        String str2 = this.f2285b;
        String valueOf = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str2).length() + String.valueOf(str).length() + 33);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    public j(c5 c5Var, String str, String str2, String str3, long j, long j2, zzam zzam) {
        b.h(str2);
        b.h(str3);
        b.k(zzam);
        this.f2284a = str2;
        this.f2285b = str3;
        this.f2286c = TextUtils.isEmpty(str) ? null : str;
        this.f2287d = j;
        this.f2288e = j2;
        if (j2 != 0 && j2 > j) {
            c5Var.i().i.c("Event created with reverse previous/current timestamps. appId, name", x3.s(str2), x3.s(str3));
        }
        this.f = zzam;
    }
}
