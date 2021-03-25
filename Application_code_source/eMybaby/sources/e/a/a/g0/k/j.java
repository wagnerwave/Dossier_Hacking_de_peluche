package e.a.a.g0.k;

import e.a.a.h0.a;
import e.a.a.h0.c;
import java.io.InputStream;

public class j extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final c f5116a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5117b = false;

    public j(c cVar) {
        if (cVar != null) {
            this.f5116a = cVar;
            return;
        }
        throw new IllegalArgumentException("Session input buffer may not be null");
    }

    public int available() {
        c cVar = this.f5116a;
        if (cVar instanceof a) {
            return ((a) cVar).length();
        }
        return 0;
    }

    public void close() {
        this.f5117b = true;
    }

    public int read() {
        if (this.f5117b) {
            return -1;
        }
        return this.f5116a.read();
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f5117b) {
            return -1;
        }
        return this.f5116a.read(bArr, i, i2);
    }
}
