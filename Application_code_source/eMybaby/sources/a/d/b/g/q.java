package a.d.b.g;

import a.c.a.f.b;
import com.nineoldandroids.util.ReflectiveProperty;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f2762a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2763b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2764c;

    public q(Class<?> cls, int i, int i2) {
        b.m(cls, "Null dependency anInterface.");
        this.f2762a = cls;
        this.f2763b = i;
        this.f2764c = i2;
    }

    public static q b(Class<?> cls) {
        return new q(cls, 1, 0);
    }

    public boolean a() {
        return this.f2763b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f2762a == qVar.f2762a && this.f2763b == qVar.f2763b && this.f2764c == qVar.f2764c;
    }

    public int hashCode() {
        return ((((this.f2762a.hashCode() ^ 1000003) * 1000003) ^ this.f2763b) * 1000003) ^ this.f2764c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f2762a);
        sb.append(", type=");
        int i = this.f2763b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : ReflectiveProperty.PREFIX_SET);
        sb.append(", direct=");
        if (this.f2764c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
