package e.b.a.a.a.u.s;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class b extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final f f5304a;

    /* renamed from: b  reason: collision with root package name */
    public final h f5305b;

    public b(f fVar) {
        this.f5304a = fVar;
        this.f5305b = null;
    }

    public b(h hVar) {
        this.f5304a = null;
        this.f5305b = hVar;
    }

    public OutputStream a() {
        f fVar = this.f5304a;
        if (fVar != null) {
            return fVar.d();
        }
        h hVar = this.f5305b;
        if (hVar != null) {
            return hVar.e();
        }
        return null;
    }

    public void flush() {
        ByteBuffer wrap;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        a().write(new d((byte) 2, true, wrap.array()).b());
        a().flush();
    }
}
