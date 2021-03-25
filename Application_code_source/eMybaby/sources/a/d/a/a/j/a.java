package a.d.a.a.j;

import a.c.a.f.b;
import a.d.a.a.e.k.a;
import java.util.Arrays;

public final class a implements a.d {
    public static final a j = new a();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2674a = false;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2675b = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f2676c = null;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2677d = false;

    /* renamed from: e  reason: collision with root package name */
    public final String f2678e = null;
    public final String f = null;
    public final boolean g = false;
    public final Long h = null;
    public final Long i = null;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2674a == aVar.f2674a && this.f2675b == aVar.f2675b && b.B(this.f2676c, aVar.f2676c) && this.f2677d == aVar.f2677d && this.g == aVar.g && b.B(this.f2678e, aVar.f2678e) && b.B(this.f, aVar.f) && b.B(this.h, aVar.h) && b.B(this.i, aVar.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f2674a), Boolean.valueOf(this.f2675b), this.f2676c, Boolean.valueOf(this.f2677d), Boolean.valueOf(this.g), this.f2678e, this.f, this.h, this.i});
    }
}
