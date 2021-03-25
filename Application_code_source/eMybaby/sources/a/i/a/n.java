package a.i.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class n extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f3630a;

    /* renamed from: b  reason: collision with root package name */
    public long f3631b;

    /* renamed from: c  reason: collision with root package name */
    public long f3632c;

    /* renamed from: d  reason: collision with root package name */
    public long f3633d;

    /* renamed from: e  reason: collision with root package name */
    public long f3634e = -1;

    public n(InputStream inputStream) {
        this.f3630a = !inputStream.markSupported() ? new BufferedInputStream(inputStream, 4096) : inputStream;
    }

    public void a(long j) {
        if (this.f3631b > this.f3633d || j < this.f3632c) {
            throw new IOException("Cannot reset");
        }
        this.f3630a.reset();
        c(this.f3632c, j);
        this.f3631b = j;
    }

    public int available() {
        return this.f3630a.available();
    }

    public long b(int i) {
        long j = this.f3631b;
        long j2 = ((long) i) + j;
        long j3 = this.f3633d;
        if (j3 < j2) {
            try {
                if (this.f3632c >= j || j > j3) {
                    this.f3632c = this.f3631b;
                    this.f3630a.mark((int) (j2 - this.f3631b));
                } else {
                    this.f3630a.reset();
                    this.f3630a.mark((int) (j2 - this.f3632c));
                    c(this.f3632c, this.f3631b);
                }
                this.f3633d = j2;
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to mark: " + e2);
            }
        }
        return this.f3631b;
    }

    public final void c(long j, long j2) {
        while (j < j2) {
            long skip = this.f3630a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public void close() {
        this.f3630a.close();
    }

    public void mark(int i) {
        this.f3634e = b(i);
    }

    public boolean markSupported() {
        return this.f3630a.markSupported();
    }

    public int read() {
        int read = this.f3630a.read();
        if (read != -1) {
            this.f3631b++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        int read = this.f3630a.read(bArr);
        if (read != -1) {
            this.f3631b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.f3630a.read(bArr, i, i2);
        if (read != -1) {
            this.f3631b += (long) read;
        }
        return read;
    }

    public void reset() {
        a(this.f3634e);
    }

    public long skip(long j) {
        long skip = this.f3630a.skip(j);
        this.f3631b += skip;
        return skip;
    }
}
