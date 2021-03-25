package e.a.a.g0.k;

import e.a.a.h0.d;
import java.io.IOException;
import java.io.OutputStream;

public class g extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final d f5111a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5112b;

    /* renamed from: c  reason: collision with root package name */
    public long f5113c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5114d = false;

    public g(d dVar, long j) {
        if (dVar == null) {
            throw new IllegalArgumentException("Session output buffer may not be null");
        } else if (j >= 0) {
            this.f5111a = dVar;
            this.f5112b = j;
        } else {
            throw new IllegalArgumentException("Content length may not be negative");
        }
    }

    public void close() {
        if (!this.f5114d) {
            this.f5114d = true;
            this.f5111a.flush();
        }
    }

    public void flush() {
        this.f5111a.flush();
    }

    public void write(int i) {
        if (this.f5114d) {
            throw new IOException("Attempted write to closed stream.");
        } else if (this.f5113c < this.f5112b) {
            this.f5111a.d(i);
            this.f5113c++;
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!this.f5114d) {
            long j = this.f5113c;
            long j2 = this.f5112b;
            if (j < j2) {
                long j3 = j2 - j;
                if (((long) i2) > j3) {
                    i2 = (int) j3;
                }
                this.f5111a.write(bArr, i, i2);
                this.f5113c += (long) i2;
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
