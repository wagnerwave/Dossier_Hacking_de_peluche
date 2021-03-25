package a.d.a.a.h.g;

import android.util.Log;

public final class g2 extends c2<Boolean> {
    public g2(l2 l2Var, String str, Boolean bool) {
        super(l2Var, str, bool, true, (h2) null);
    }

    public final /* synthetic */ Object e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (l1.f1793c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (l1.f1794d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String g = super.g();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(g).length() + 28);
        sb.append("Invalid boolean value for ");
        sb.append(g);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
