package e.a.a.g0.k;

import e.a.a.h0.d;
import java.io.IOException;
import java.io.OutputStream;

public class k extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final d f5118a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5119b = false;

    public k(d dVar) {
        if (dVar != null) {
            this.f5118a = dVar;
            return;
        }
        throw new IllegalArgumentException("Session output buffer may not be null");
    }

    public void close() {
        if (!this.f5119b) {
            this.f5119b = true;
            this.f5118a.flush();
        }
    }

    public void flush() {
        this.f5118a.flush();
    }

    public void write(int i) {
        if (!this.f5119b) {
            this.f5118a.d(i);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!this.f5119b) {
            this.f5118a.write(bArr, i, i2);
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
