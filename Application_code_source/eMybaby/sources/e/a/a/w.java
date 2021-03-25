package e.a.a;

import e.a.a.l0.b;
import java.io.Serializable;

public class w implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5194a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5195b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5196c;

    public w(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Protocol name must not be null.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Protocol major version number must not be negative.");
        } else if (i2 >= 0) {
            this.f5194a = str;
            this.f5195b = i;
            this.f5196c = i2;
        } else {
            throw new IllegalArgumentException("Protocol minor version number may not be negative");
        }
    }

    public w b(int i, int i2) {
        return (i == this.f5195b && i2 == this.f5196c) ? this : new w(this.f5194a, i, i2);
    }

    public final boolean c(w wVar) {
        if (!(wVar != null && this.f5194a.equals(wVar.f5194a))) {
            return false;
        }
        if (wVar == null) {
            throw new IllegalArgumentException("Protocol version must not be null.");
        } else if (this.f5194a.equals(wVar.f5194a)) {
            int i = this.f5195b - wVar.f5195b;
            if (i == 0) {
                i = this.f5196c - wVar.f5196c;
            }
            if (i <= 0) {
                return true;
            }
            return false;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Versions for different protocols cannot be compared. ");
            stringBuffer.append(this);
            stringBuffer.append(" ");
            stringBuffer.append(wVar);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f5194a.equals(wVar.f5194a) && this.f5195b == wVar.f5195b && this.f5196c == wVar.f5196c;
    }

    public final int hashCode() {
        return (this.f5194a.hashCode() ^ (this.f5195b * 100000)) ^ this.f5196c;
    }

    public String toString() {
        b bVar = new b(16);
        bVar.b(this.f5194a);
        bVar.a('/');
        bVar.b(Integer.toString(this.f5195b));
        bVar.a('.');
        bVar.b(Integer.toString(this.f5196c));
        return bVar.toString();
    }
}
