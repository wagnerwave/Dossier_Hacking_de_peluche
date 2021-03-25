package e.a.a.g0.f;

import e.a.a.b0.f;
import e.a.a.b0.i;
import e.a.a.b0.k;
import e.a.a.c;
import e.a.a.l0.b;
import e.a.a.m;

public class h extends a {

    /* renamed from: b  reason: collision with root package name */
    public final f f4954b;

    /* renamed from: c  reason: collision with root package name */
    public a f4955c = a.UNINITIATED;

    /* renamed from: d  reason: collision with root package name */
    public String f4956d = null;

    public enum a {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED
    }

    public h(f fVar) {
        this.f4954b = fVar;
    }

    public c c(e.a.a.b0.h hVar, m mVar) {
        try {
            k kVar = (k) hVar;
            a aVar = this.f4955c;
            if (aVar == a.CHALLENGE_RECEIVED || aVar == a.FAILED) {
                throw null;
            } else if (aVar == a.MSG_TYPE2_RECEVIED) {
                throw null;
            } else {
                StringBuilder n = a.a.a.a.a.n("Unexpected state: ");
                n.append(this.f4955c);
                throw new f(n.toString());
            }
        } catch (ClassCastException unused) {
            StringBuilder n2 = a.a.a.a.a.n("Credentials cannot be used for NTLM authentication: ");
            n2.append(hVar.getClass().getName());
            throw new i(n2.toString());
        }
    }

    public String d() {
        return null;
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        a aVar = this.f4955c;
        return aVar == a.MSG_TYPE3_GENERATED || aVar == a.FAILED;
    }

    public String g() {
        return "ntlm";
    }

    public void h(b bVar, int i, int i2) {
        String i3 = bVar.i(i, i2);
        if (i3.length() == 0) {
            this.f4955c = this.f4955c == a.UNINITIATED ? a.CHALLENGE_RECEIVED : a.FAILED;
            i3 = null;
        } else {
            this.f4955c = a.MSG_TYPE2_RECEVIED;
        }
        this.f4956d = i3;
    }
}
