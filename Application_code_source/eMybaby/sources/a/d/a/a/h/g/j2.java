package a.d.a.a.h.g;

import android.util.Log;

public final class j2 extends c2<Double> {
    public j2(l2 l2Var, String str, Double d2) {
        super(l2Var, str, d2, true, (h2) null);
    }

    public final Object e(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String g = super.g();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(g).length() + 27);
        sb.append("Invalid double value for ");
        sb.append(g);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
