package e.a.a.g0.k;

import e.a.a.h0.d;
import e.a.a.i0.h;
import e.a.a.i0.r;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final d f5089a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a.a.l0.b f5090b;

    /* renamed from: c  reason: collision with root package name */
    public final r f5091c;

    public b(d dVar, r rVar) {
        if (dVar != null) {
            this.f5089a = dVar;
            this.f5090b = new e.a.a.l0.b(128);
            this.f5091c = rVar == null ? h.f5144a : rVar;
            return;
        }
        throw new IllegalArgumentException("Session input buffer may not be null");
    }
}
