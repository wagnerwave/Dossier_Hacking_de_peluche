package e.a.a.g0.h;

import e.a.a.d0.l.a;
import e.a.a.d0.l.d;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final f f5010a;

    /* renamed from: b  reason: collision with root package name */
    public final e f5011b;

    /* renamed from: c  reason: collision with root package name */
    public volatile a f5012c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f5013d;

    /* renamed from: e  reason: collision with root package name */
    public volatile d f5014e;

    public b(f fVar, a aVar) {
        if (fVar != null) {
            this.f5010a = fVar;
            this.f5011b = new e();
            this.f5012c = aVar;
            this.f5014e = null;
            return;
        }
        throw new IllegalArgumentException("Connection operator may not be null");
    }

    public void a() {
        this.f5014e = null;
        this.f5013d = null;
    }
}
