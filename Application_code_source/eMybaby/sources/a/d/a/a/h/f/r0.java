package a.d.a.a.h.f;

import a.a.a.a.a;

public class r0 extends f {

    /* renamed from: c  reason: collision with root package name */
    public static r0 f1553c;

    public r0(h hVar) {
        super(hVar);
    }

    public static String w(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        String str = "-";
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? String.valueOf(obj) : obj instanceof Throwable ? obj.getClass().getCanonicalName() : str;
        }
        Long l = (Long) obj;
        int i = (Math.abs(l.longValue()) > 100 ? 1 : (Math.abs(l.longValue()) == 100 ? 0 : -1));
        String valueOf = String.valueOf(obj);
        if (i < 0) {
            return valueOf;
        }
        if (valueOf.charAt(0) != '-') {
            str = "";
        }
        String valueOf2 = String.valueOf(Math.abs(l.longValue()));
        StringBuilder n = a.n(str);
        n.append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))));
        n.append("...");
        n.append(str);
        n.append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d));
        return n.toString();
    }

    public final void t() {
        synchronized (r0.class) {
            f1553c = this;
        }
    }

    public final void v(n0 n0Var, String str) {
        l(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), n0Var.toString());
    }
}
