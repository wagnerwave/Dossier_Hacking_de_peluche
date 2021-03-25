package e.a.a.g0.k;

import com.tuya.smart.common.oOO0O0O0;
import e.a.a.h0.d;
import java.io.IOException;
import java.io.OutputStream;

public class e extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final d f5102a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f5103b = new byte[2048];

    /* renamed from: c  reason: collision with root package name */
    public int f5104c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5105d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5106e = false;

    public e(d dVar) {
        this.f5102a = dVar;
    }

    public void a() {
        int i = this.f5104c;
        if (i > 0) {
            this.f5102a.b(Integer.toHexString(i));
            this.f5102a.write(this.f5103b, 0, this.f5104c);
            this.f5102a.b("");
            this.f5104c = 0;
        }
    }

    public void close() {
        if (!this.f5106e) {
            this.f5106e = true;
            if (!this.f5105d) {
                a();
                this.f5102a.b(oOO0O0O0.O0000oO0);
                this.f5102a.b("");
                this.f5105d = true;
            }
            this.f5102a.flush();
        }
    }

    public void flush() {
        a();
        this.f5102a.flush();
    }

    public void write(int i) {
        if (!this.f5106e) {
            byte[] bArr = this.f5103b;
            int i2 = this.f5104c;
            bArr[i2] = (byte) i;
            int i3 = i2 + 1;
            this.f5104c = i3;
            if (i3 == bArr.length) {
                a();
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!this.f5106e) {
            byte[] bArr2 = this.f5103b;
            int length = bArr2.length;
            int i3 = this.f5104c;
            if (i2 >= length - i3) {
                this.f5102a.b(Integer.toHexString(i3 + i2));
                this.f5102a.write(this.f5103b, 0, this.f5104c);
                this.f5102a.write(bArr, i, i2);
                this.f5102a.b("");
                this.f5104c = 0;
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.f5104c += i2;
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
