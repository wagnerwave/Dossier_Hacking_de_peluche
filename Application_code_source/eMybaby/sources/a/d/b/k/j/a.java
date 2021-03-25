package a.d.b.k.j;

import a.d.b.k.j.c;
import a.d.b.k.j.d;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final String f2802a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a f2803b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2804c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2805d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2806e;
    public final long f;
    public final String g;

    public static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        public String f2807a;

        /* renamed from: b  reason: collision with root package name */
        public c.a f2808b;

        /* renamed from: c  reason: collision with root package name */
        public String f2809c;

        /* renamed from: d  reason: collision with root package name */
        public String f2810d;

        /* renamed from: e  reason: collision with root package name */
        public Long f2811e;
        public Long f;
        public String g;

        public b() {
        }

        public b(d dVar, C0066a aVar) {
            a aVar2 = (a) dVar;
            this.f2807a = aVar2.f2802a;
            this.f2808b = aVar2.f2803b;
            this.f2809c = aVar2.f2804c;
            this.f2810d = aVar2.f2805d;
            this.f2811e = Long.valueOf(aVar2.f2806e);
            this.f = Long.valueOf(aVar2.f);
            this.g = aVar2.g;
        }

        public d a() {
            String str = this.f2808b == null ? " registrationStatus" : "";
            if (this.f2811e == null) {
                str = a.a.a.a.a.k(str, " expiresInSecs");
            }
            if (this.f == null) {
                str = a.a.a.a.a.k(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                return new a(this.f2807a, this.f2808b, this.f2809c, this.f2810d, this.f2811e.longValue(), this.f.longValue(), this.g, (C0066a) null);
            }
            throw new IllegalStateException(a.a.a.a.a.k("Missing required properties:", str));
        }

        public d.a b(long j) {
            this.f2811e = Long.valueOf(j);
            return this;
        }

        public d.a c(c.a aVar) {
            if (aVar != null) {
                this.f2808b = aVar;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public d.a d(long j) {
            this.f = Long.valueOf(j);
            return this;
        }
    }

    public a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4, C0066a aVar2) {
        this.f2802a = str;
        this.f2803b = aVar;
        this.f2804c = str2;
        this.f2805d = str3;
        this.f2806e = j;
        this.f = j2;
        this.g = str4;
    }

    public d.a c() {
        return new b(this, (C0066a) null);
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f2802a;
        if (str3 != null ? str3.equals(((a) dVar).f2802a) : ((a) dVar).f2802a == null) {
            if (this.f2803b.equals(((a) dVar).f2803b) && ((str = this.f2804c) != null ? str.equals(((a) dVar).f2804c) : ((a) dVar).f2804c == null) && ((str2 = this.f2805d) != null ? str2.equals(((a) dVar).f2805d) : ((a) dVar).f2805d == null)) {
                a aVar = (a) dVar;
                if (this.f2806e == aVar.f2806e && this.f == aVar.f) {
                    String str4 = this.g;
                    if (str4 == null) {
                        if (aVar.g == null) {
                            return true;
                        }
                    } else if (str4.equals(aVar.g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2802a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f2803b.hashCode()) * 1000003;
        String str2 = this.f2804c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2805d;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.f2806e;
        long j2 = this.f;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("PersistedInstallationEntry{firebaseInstallationId=");
        n.append(this.f2802a);
        n.append(", registrationStatus=");
        n.append(this.f2803b);
        n.append(", authToken=");
        n.append(this.f2804c);
        n.append(", refreshToken=");
        n.append(this.f2805d);
        n.append(", expiresInSecs=");
        n.append(this.f2806e);
        n.append(", tokenCreationEpochInSecs=");
        n.append(this.f);
        n.append(", fisError=");
        return a.a.a.a.a.m(n, this.g, "}");
    }
}
