package e.a.a.g0.k;

import android.support.v4.media.session.PlaybackStateCompat;
import e.a.a.h0.a;
import e.a.a.h0.c;
import java.io.IOException;
import java.io.InputStream;

public class f extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public long f5107a;

    /* renamed from: b  reason: collision with root package name */
    public long f5108b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5109c = false;

    /* renamed from: d  reason: collision with root package name */
    public c f5110d = null;

    public f(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        } else if (j >= 0) {
            this.f5110d = cVar;
            this.f5107a = j;
        } else {
            throw new IllegalArgumentException("Content length may not be negative");
        }
    }

    public int available() {
        c cVar = this.f5110d;
        if (cVar instanceof a) {
            return Math.min(((a) cVar).length(), (int) (this.f5107a - this.f5108b));
        }
        return 0;
    }

    public void close() {
        if (!this.f5109c) {
            try {
                if (this.f5108b < this.f5107a) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f5109c = true;
            }
        }
    }

    public int read() {
        if (this.f5109c) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f5108b >= this.f5107a) {
            return -1;
        } else {
            int read = this.f5110d.read();
            long j = this.f5108b;
            if (read != -1) {
                this.f5108b = j + 1;
            } else if (j < this.f5107a) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Premature end of Content-Length delimited message body (expected: ");
                stringBuffer.append(this.f5107a);
                stringBuffer.append("; received: ");
                stringBuffer.append(this.f5108b);
                throw new e.a.a.a(stringBuffer.toString());
            }
            return read;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.f5109c) {
            long j = this.f5108b;
            long j2 = this.f5107a;
            if (j >= j2) {
                return -1;
            }
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int read = this.f5110d.read(bArr, i, i2);
            if (read != -1 || this.f5108b >= this.f5107a) {
                if (read > 0) {
                    this.f5108b += (long) read;
                }
                return read;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Premature end of Content-Length delimited message body (expected: ");
            stringBuffer.append(this.f5107a);
            stringBuffer.append("; received: ");
            stringBuffer.append(this.f5108b);
            throw new e.a.a.a(stringBuffer.toString());
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public long skip(long j) {
        int read;
        if (j <= 0) {
            return 0;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.f5107a - this.f5108b);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, min))) != -1) {
            long j3 = (long) read;
            j2 += j3;
            min -= j3;
        }
        return j2;
    }
}
