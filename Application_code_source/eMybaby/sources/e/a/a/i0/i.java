package e.a.a.i0;

import e.a.a.l0.b;
import e.a.a.q;
import e.a.a.u;
import e.a.a.w;

public class i implements s {

    /* renamed from: b  reason: collision with root package name */
    public static final i f5145b = new i();

    /* renamed from: a  reason: collision with root package name */
    public final w f5146a = q.f;

    public w a(b bVar, t tVar) {
        String str = this.f5146a.f5194a;
        int length = str.length();
        int i = tVar.f5169c;
        int i2 = tVar.f5168b;
        b(bVar, tVar);
        int i3 = tVar.f5169c;
        int i4 = i3 + length;
        if (i4 + 4 <= i2) {
            boolean z = false;
            boolean z2 = true;
            int i5 = 0;
            while (z2 && i5 < length) {
                z2 = bVar.f5183a[i3 + i5] == str.charAt(i5);
                i5++;
            }
            if (z2) {
                if (bVar.f5183a[i4] == '/') {
                    z = true;
                }
                z2 = z;
            }
            if (z2) {
                int i6 = length + 1 + i3;
                int g = bVar.g(46, i6, i2);
                if (g != -1) {
                    try {
                        int parseInt = Integer.parseInt(bVar.i(i6, g));
                        int i7 = g + 1;
                        int g2 = bVar.g(32, i7, i2);
                        if (g2 == -1) {
                            g2 = i2;
                        }
                        try {
                            int parseInt2 = Integer.parseInt(bVar.i(i7, g2));
                            tVar.b(g2);
                            return this.f5146a.b(parseInt, parseInt2);
                        } catch (NumberFormatException unused) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Invalid protocol minor version number: ");
                            stringBuffer.append(bVar.h(i, i2));
                            throw new u(stringBuffer.toString());
                        }
                    } catch (NumberFormatException unused2) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Invalid protocol major version number: ");
                        stringBuffer2.append(bVar.h(i, i2));
                        throw new u(stringBuffer2.toString());
                    }
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Invalid protocol version number: ");
                    stringBuffer3.append(bVar.h(i, i2));
                    throw new u(stringBuffer3.toString());
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Not a valid protocol version: ");
                stringBuffer4.append(bVar.h(i, i2));
                throw new u(stringBuffer4.toString());
            }
        } else {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Not a valid protocol version: ");
            stringBuffer5.append(bVar.h(i, i2));
            throw new u(stringBuffer5.toString());
        }
    }

    public void b(b bVar, t tVar) {
        int i = tVar.f5169c;
        int i2 = tVar.f5168b;
        while (i < i2 && a.e.a.a.r.b.N(bVar.f5183a[i])) {
            i++;
        }
        tVar.b(i);
    }
}
