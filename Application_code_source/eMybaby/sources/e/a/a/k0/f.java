package e.a.a.k0;

import e.a.a.m;
import e.a.a.n;
import e.a.a.o;
import e.a.a.p;

public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public final n[] f5179a;

    /* renamed from: b  reason: collision with root package name */
    public final p[] f5180b;

    public f(n[] nVarArr, p[] pVarArr) {
        int length = nVarArr.length;
        this.f5179a = new n[length];
        for (int i = 0; i < length; i++) {
            this.f5179a[i] = nVarArr[i];
        }
        int length2 = pVarArr.length;
        this.f5180b = new p[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            this.f5180b[i2] = pVarArr[i2];
        }
    }

    public void b(m mVar, c cVar) {
        int i = 0;
        while (true) {
            n[] nVarArr = this.f5179a;
            if (i < nVarArr.length) {
                nVarArr[i].b(mVar, cVar);
                i++;
            } else {
                return;
            }
        }
    }

    public void c(o oVar, c cVar) {
        int i = 0;
        while (true) {
            p[] pVarArr = this.f5180b;
            if (i < pVarArr.length) {
                pVarArr[i].c(oVar, cVar);
                i++;
            } else {
                return;
            }
        }
    }
}
