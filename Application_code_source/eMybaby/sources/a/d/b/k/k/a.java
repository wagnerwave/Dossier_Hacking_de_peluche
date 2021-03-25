package a.d.b.k.k;

import a.d.b.k.k.d;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final String f2822a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2823b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2824c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2825d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a f2826e;

    public a(String str, String str2, String str3, e eVar, d.a aVar, C0067a aVar2) {
        this.f2822a = str;
        this.f2823b = str2;
        this.f2824c = str3;
        this.f2825d = eVar;
        this.f2826e = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f2822a;
        if (str != null ? str.equals(((a) dVar).f2822a) : ((a) dVar).f2822a == null) {
            String str2 = this.f2823b;
            if (str2 != null ? str2.equals(((a) dVar).f2823b) : ((a) dVar).f2823b == null) {
                String str3 = this.f2824c;
                if (str3 != null ? str3.equals(((a) dVar).f2824c) : ((a) dVar).f2824c == null) {
                    e eVar = this.f2825d;
                    if (eVar != null ? eVar.equals(((a) dVar).f2825d) : ((a) dVar).f2825d == null) {
                        d.a aVar = this.f2826e;
                        a aVar2 = (a) dVar;
                        if (aVar == null) {
                            if (aVar2.f2826e == null) {
                                return true;
                            }
                        } else if (aVar.equals(aVar2.f2826e)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2822a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f2823b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2824c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        e eVar = this.f2825d;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        d.a aVar = this.f2826e;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode4 ^ i;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("InstallationResponse{uri=");
        n.append(this.f2822a);
        n.append(", fid=");
        n.append(this.f2823b);
        n.append(", refreshToken=");
        n.append(this.f2824c);
        n.append(", authToken=");
        n.append(this.f2825d);
        n.append(", responseCode=");
        n.append(this.f2826e);
        n.append("}");
        return n.toString();
    }
}
