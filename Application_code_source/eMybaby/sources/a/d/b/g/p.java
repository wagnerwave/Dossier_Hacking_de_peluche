package a.d.b.g;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f2760a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2761b;

    public p(Class cls, boolean z, n nVar) {
        this.f2760a = cls;
        this.f2761b = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return pVar.f2760a.equals(this.f2760a) && pVar.f2761b == this.f2761b;
    }

    public int hashCode() {
        return ((this.f2760a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f2761b).hashCode();
    }
}
