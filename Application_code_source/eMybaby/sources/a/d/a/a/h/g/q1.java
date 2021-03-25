package a.d.a.a.h.g;

import android.content.Context;
import javax.annotation.Nullable;

public final class q1 extends k2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1891a;

    /* renamed from: b  reason: collision with root package name */
    public final u2<s2<y1>> f1892b;

    public q1(Context context, @Nullable u2<s2<y1>> u2Var) {
        this.f1891a = context;
        this.f1892b = u2Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            if (this.f1891a.equals(((q1) k2Var).f1891a)) {
                u2<s2<y1>> u2Var = this.f1892b;
                q1 q1Var = (q1) k2Var;
                return u2Var != null ? u2Var.equals(q1Var.f1892b) : q1Var.f1892b == null;
            }
        }
    }

    public final int hashCode() {
        int hashCode = (this.f1891a.hashCode() ^ 1000003) * 1000003;
        u2<s2<y1>> u2Var = this.f1892b;
        return hashCode ^ (u2Var == null ? 0 : u2Var.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1891a);
        String valueOf2 = String.valueOf(this.f1892b);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 46);
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }
}
