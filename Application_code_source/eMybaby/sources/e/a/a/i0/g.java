package e.a.a.i0;

import e.a.a.o;
import e.a.a.w;
import e.a.a.x;
import e.a.a.z;
import java.util.Locale;

public class g extends a implements o {

    /* renamed from: c  reason: collision with root package name */
    public z f5142c;

    /* renamed from: d  reason: collision with root package name */
    public e.a.a.g f5143d;

    public g(z zVar, x xVar, Locale locale) {
        this.f5142c = zVar;
        if (locale == null) {
            Locale.getDefault();
        }
    }

    public e.a.a.g b() {
        return this.f5143d;
    }

    public void q(e.a.a.g gVar) {
        this.f5143d = gVar;
    }

    public z s() {
        return this.f5142c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5142c);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5125a);
        return stringBuffer.toString();
    }

    public w v() {
        return ((m) this.f5142c).f5156a;
    }
}
