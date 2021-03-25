package a.d.b.k.k;

import a.d.b.k.k.e;

public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2827a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2828b;

    /* renamed from: c  reason: collision with root package name */
    public final e.b f2829c;

    /* renamed from: a.d.b.k.k.b$b  reason: collision with other inner class name */
    public static final class C0068b extends e.a {

        /* renamed from: a  reason: collision with root package name */
        public String f2830a;

        /* renamed from: b  reason: collision with root package name */
        public Long f2831b;

        /* renamed from: c  reason: collision with root package name */
        public e.b f2832c;

        public e a() {
            String str = this.f2831b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new b(this.f2830a, this.f2831b.longValue(), this.f2832c, (a) null);
            }
            throw new IllegalStateException(a.a.a.a.a.k("Missing required properties:", str));
        }

        public e.a b(long j) {
            this.f2831b = Long.valueOf(j);
            return this;
        }
    }

    public b(String str, long j, e.b bVar, a aVar) {
        this.f2827a = str;
        this.f2828b = j;
        this.f2829c = bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f2827a;
        if (str != null ? str.equals(((b) eVar).f2827a) : ((b) eVar).f2827a == null) {
            if (this.f2828b == ((b) eVar).f2828b) {
                e.b bVar = this.f2829c;
                b bVar2 = (b) eVar;
                if (bVar == null) {
                    if (bVar2.f2829c == null) {
                        return true;
                    }
                } else if (bVar.equals(bVar2.f2829c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2827a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f2828b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        e.b bVar = this.f2829c;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("TokenResult{token=");
        n.append(this.f2827a);
        n.append(", tokenExpirationTimestamp=");
        n.append(this.f2828b);
        n.append(", responseCode=");
        n.append(this.f2829c);
        n.append("}");
        return n.toString();
    }
}
