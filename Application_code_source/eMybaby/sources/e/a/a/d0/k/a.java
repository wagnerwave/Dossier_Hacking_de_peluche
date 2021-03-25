package e.a.a.d0.k;

import e.a.a.j0.c;

@Deprecated
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f4861a = new C0106a();

    /* renamed from: e.a.a.d0.k.a$a  reason: collision with other inner class name */
    public static class C0106a implements b {
        public int a(e.a.a.d0.l.a aVar) {
            return 2;
        }
    }

    @Deprecated
    public static long a(c cVar) {
        if (cVar != null) {
            Long l = (Long) cVar.e("http.conn-manager.timeout");
            return l != null ? l.longValue() : (long) cVar.b("http.connection.timeout", 0);
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }
}
