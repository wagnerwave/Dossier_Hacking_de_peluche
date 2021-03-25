package a.d.a.a.h.g;

import android.util.Log;

public final class h2 extends c2<Long> {
    public h2(l2 l2Var, String str, Long l) {
        super(l2Var, str, l, true, (h2) null);
    }

    public final Object e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String g = super.g();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(g).length() + 25);
        sb.append("Invalid long value for ");
        sb.append(g);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
