package e.a.a.i0;

import e.a.a.b;
import e.a.a.d;
import e.a.a.u;
import java.io.Serializable;

public class o implements b, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5163a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a.a.l0.b f5164b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5165c;

    public o(e.a.a.l0.b bVar) {
        if (bVar != null) {
            int g = bVar.g(58, 0, bVar.f5184b);
            if (g != -1) {
                String i = bVar.i(0, g);
                if (i.length() != 0) {
                    this.f5164b = bVar;
                    this.f5163a = i;
                    this.f5165c = g + 1;
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid header: ");
                stringBuffer.append(bVar.toString());
                throw new u(stringBuffer.toString());
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Invalid header: ");
            stringBuffer2.append(bVar.toString());
            throw new u(stringBuffer2.toString());
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    public e.a.a.l0.b b() {
        return this.f5164b;
    }

    public d[] c() {
        t tVar = new t(0, this.f5164b.f5184b);
        tVar.b(this.f5165c);
        return e.f5137a.b(this.f5164b, tVar);
    }

    public Object clone() {
        return super.clone();
    }

    public int d() {
        return this.f5165c;
    }

    public String getName() {
        return this.f5163a;
    }

    public String getValue() {
        e.a.a.l0.b bVar = this.f5164b;
        return bVar.i(this.f5165c, bVar.f5184b);
    }

    public String toString() {
        return this.f5164b.toString();
    }
}
