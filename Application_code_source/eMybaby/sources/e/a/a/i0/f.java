package e.a.a.i0;

import a.e.a.a.r.b;
import e.a.a.m;
import e.a.a.w;
import e.a.a.y;

public class f extends a implements m {

    /* renamed from: c  reason: collision with root package name */
    public final String f5139c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5140d;

    /* renamed from: e  reason: collision with root package name */
    public y f5141e;

    public f(String str, String str2, w wVar) {
        l lVar = new l(str, str2, wVar);
        this.f5141e = lVar;
        this.f5139c = lVar.f5154b;
        this.f5140d = lVar.f5155c;
    }

    public y f() {
        if (this.f5141e == null) {
            this.f5141e = new l(this.f5139c, this.f5140d, b.E(getParams()));
        }
        return this.f5141e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5139c);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5140d);
        stringBuffer.append(" ");
        stringBuffer.append(this.f5125a);
        return stringBuffer.toString();
    }

    public w v() {
        return ((l) f()).f5153a;
    }
}
