package a.d.b.m;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2848a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2849b;

    public a(String str, String str2) {
        if (str != null) {
            this.f2848a = str;
            if (str2 != null) {
                this.f2849b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        a aVar = (a) ((e) obj);
        if (!this.f2848a.equals(aVar.f2848a) || !this.f2849b.equals(aVar.f2849b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f2848a.hashCode() ^ 1000003) * 1000003) ^ this.f2849b.hashCode();
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("LibraryVersion{libraryName=");
        n.append(this.f2848a);
        n.append(", version=");
        return a.a.a.a.a.m(n, this.f2849b, "}");
    }
}
