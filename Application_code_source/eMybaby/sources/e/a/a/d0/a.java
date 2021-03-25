package e.a.a.d0;

import a.e.a.a.r.b;
import e.a.a.f0.e;
import e.a.a.g;
import java.io.InputStream;
import java.io.OutputStream;

public class a extends e implements g {

    /* renamed from: b  reason: collision with root package name */
    public e.a.a.g0.h.a f4856b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4857c;

    public a(g gVar, e.a.a.g0.h.a aVar, boolean z) {
        super(gVar);
        if (aVar != null) {
            this.f4856b = aVar;
            this.f4857c = z;
            return;
        }
        throw new IllegalArgumentException("Connection may not be null.");
    }

    public final void a() {
        if (this.f4856b != null) {
            try {
                if (this.f4857c) {
                    b.f(this.f4908a);
                    this.f4856b.f5007c = true;
                }
            } finally {
                d();
            }
        }
    }

    public void d() {
        e.a.a.g0.h.a aVar = this.f4856b;
        if (aVar != null) {
            try {
                aVar.l();
            } finally {
                this.f4856b = null;
            }
        }
    }

    public InputStream getContent() {
        return new h(this.f4908a.getContent(), this);
    }

    public boolean isRepeatable() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        this.f4908a.writeTo(outputStream);
        a();
    }
}
