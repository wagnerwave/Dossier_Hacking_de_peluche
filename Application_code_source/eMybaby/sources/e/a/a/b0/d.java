package e.a.a.b0;

import a.e.a.a.r.b;
import java.util.Locale;

public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final String f4837e = null;
    public static final String f = null;
    public static final String g = null;

    /* renamed from: a  reason: collision with root package name */
    public final String f4838a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4839b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4840c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4841d;

    public d(String str, int i, String str2, String str3) {
        this.f4840c = str == null ? f4837e : str.toLowerCase(Locale.ENGLISH);
        this.f4841d = i < 0 ? -1 : i;
        this.f4839b = str2 == null ? f : str2;
        this.f4838a = str3 == null ? g : str3.toUpperCase(Locale.ENGLISH);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return super.equals(obj);
        }
        d dVar = (d) obj;
        return b.m(this.f4840c, dVar.f4840c) && this.f4841d == dVar.f4841d && b.m(this.f4839b, dVar.f4839b) && b.m(this.f4838a, dVar.f4838a);
    }

    public int hashCode() {
        return b.G(b.G((b.G(17, this.f4840c) * 37) + this.f4841d, this.f4839b), this.f4838a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f4838a;
        if (str != null) {
            sb.append(str.toUpperCase(Locale.ENGLISH));
            sb.append(' ');
        }
        if (this.f4839b != null) {
            sb.append('\'');
            sb.append(this.f4839b);
            sb.append('\'');
        } else {
            sb.append("<any realm>");
        }
        if (this.f4840c != null) {
            sb.append('@');
            sb.append(this.f4840c);
            if (this.f4841d >= 0) {
                sb.append(':');
                sb.append(this.f4841d);
            }
        }
        return sb.toString();
    }
}
