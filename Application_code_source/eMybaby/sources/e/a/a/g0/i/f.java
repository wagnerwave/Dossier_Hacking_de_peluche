package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.k;
import e.a.a.e0.m;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f5064a;

    public f(String[] strArr) {
        if (strArr != null) {
            this.f5064a = strArr;
            return;
        }
        throw new IllegalArgumentException("Array of date patterns may not be null");
    }

    public void c(m mVar, String str) {
        if (str != null) {
            try {
                ((c) mVar).f5063e = p.a(str, this.f5064a);
            } catch (o unused) {
                throw new k(a.k("Unable to parse expires attribute: ", str));
            }
        } else {
            throw new k("Missing value for expires attribute");
        }
    }
}
