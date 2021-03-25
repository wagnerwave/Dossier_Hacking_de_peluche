package e.a.a.g0.k;

import com.tutk.IOTC.AVFrame;
import e.a.a.h0.a;
import java.io.InputStream;

public abstract class c implements e.a.a.h0.c, a {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f5092a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f5093b;

    /* renamed from: c  reason: collision with root package name */
    public int f5094c;

    /* renamed from: d  reason: collision with root package name */
    public int f5095d;

    /* renamed from: e  reason: collision with root package name */
    public e.a.a.l0.a f5096e = null;
    public String f = "US-ASCII";
    public boolean g = true;
    public int h = -1;
    public int i = 512;
    public i j;

    public i a() {
        return this.j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (r3 == -1) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(e.a.a.l0.b r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x00eb
            r0 = 0
            r1 = 1
            r2 = 1
            r3 = 0
        L_0x0006:
            r4 = 13
            r5 = 10
            r6 = -1
            if (r2 == 0) goto L_0x0099
            int r7 = r9.f5094c
        L_0x000f:
            int r8 = r9.f5095d
            if (r7 >= r8) goto L_0x001d
            byte[] r8 = r9.f5093b
            byte r8 = r8[r7]
            if (r8 != r5) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            int r7 = r7 + 1
            goto L_0x000f
        L_0x001d:
            r7 = -1
        L_0x001e:
            if (r7 == r6) goto L_0x0068
            e.a.a.l0.a r2 = r9.f5096e
            int r2 = r2.f5182b
            if (r2 != 0) goto L_0x0028
            r2 = 1
            goto L_0x0029
        L_0x0028:
            r2 = 0
        L_0x0029:
            if (r2 == 0) goto L_0x0058
            int r0 = r9.f5094c
            int r1 = r7 + 1
            r9.f5094c = r1
            if (r7 <= 0) goto L_0x003c
            byte[] r1 = r9.f5093b
            int r2 = r7 + -1
            byte r1 = r1[r2]
            if (r1 != r4) goto L_0x003c
            r7 = r2
        L_0x003c:
            int r7 = r7 - r0
            boolean r1 = r9.g
            if (r1 == 0) goto L_0x0047
            byte[] r1 = r9.f5093b
            r10.c(r1, r0, r7)
            goto L_0x0057
        L_0x0047:
            java.lang.String r1 = new java.lang.String
            byte[] r2 = r9.f5093b
            java.lang.String r3 = r9.f
            r1.<init>(r2, r0, r7, r3)
            r10.b(r1)
            int r7 = r1.length()
        L_0x0057:
            return r7
        L_0x0058:
            int r7 = r7 + 1
            int r2 = r9.f5094c
            int r4 = r7 - r2
            e.a.a.l0.a r5 = r9.f5096e
            byte[] r6 = r9.f5093b
            r5.a(r6, r2, r4)
            r9.f5094c = r7
            goto L_0x0084
        L_0x0068:
            boolean r3 = r9.f()
            if (r3 == 0) goto L_0x007e
            int r3 = r9.f5095d
            int r4 = r9.f5094c
            int r3 = r3 - r4
            e.a.a.l0.a r5 = r9.f5096e
            byte[] r7 = r9.f5093b
            r5.a(r7, r4, r3)
            int r3 = r9.f5095d
            r9.f5094c = r3
        L_0x007e:
            int r3 = r9.e()
            if (r3 != r6) goto L_0x0085
        L_0x0084:
            r2 = 0
        L_0x0085:
            int r4 = r9.h
            if (r4 <= 0) goto L_0x0006
            e.a.a.l0.a r5 = r9.f5096e
            int r5 = r5.f5182b
            if (r5 >= r4) goto L_0x0091
            goto L_0x0006
        L_0x0091:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r0 = "Maximum line length limit exceeded"
            r10.<init>(r0)
            throw r10
        L_0x0099:
            if (r3 != r6) goto L_0x00a6
            e.a.a.l0.a r2 = r9.f5096e
            int r2 = r2.f5182b
            if (r2 != 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r1 = 0
        L_0x00a3:
            if (r1 == 0) goto L_0x00a6
            return r6
        L_0x00a6:
            e.a.a.l0.a r1 = r9.f5096e
            int r2 = r1.f5182b
            if (r2 <= 0) goto L_0x00c6
            int r3 = r2 + -1
            byte[] r7 = r1.f5181a
            byte r7 = r7[r3]
            if (r7 != r5) goto L_0x00b8
            r1.c(r3)
            r2 = r3
        L_0x00b8:
            if (r2 <= 0) goto L_0x00c6
            e.a.a.l0.a r1 = r9.f5096e
            int r2 = r2 + r6
            byte[] r3 = r1.f5181a
            byte r3 = r3[r2]
            if (r3 != r4) goto L_0x00c6
            r1.c(r2)
        L_0x00c6:
            e.a.a.l0.a r1 = r9.f5096e
            int r2 = r1.f5182b
            boolean r3 = r9.g
            if (r3 == 0) goto L_0x00d4
            byte[] r1 = r1.f5181a
            r10.c(r1, r0, r2)
            goto L_0x00e6
        L_0x00d4:
            java.lang.String r1 = new java.lang.String
            e.a.a.l0.a r3 = r9.f5096e
            byte[] r3 = r3.f5181a
            java.lang.String r4 = r9.f
            r1.<init>(r3, r0, r2, r4)
            int r2 = r1.length()
            r10.b(r1)
        L_0x00e6:
            e.a.a.l0.a r10 = r9.f5096e
            r10.f5182b = r0
            return r2
        L_0x00eb:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Char array buffer may not be null"
            r10.<init>(r0)
            goto L_0x00f4
        L_0x00f3:
            throw r10
        L_0x00f4:
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.k.c.b(e.a.a.l0.b):int");
    }

    public int e() {
        int i2 = this.f5094c;
        if (i2 > 0) {
            int i3 = this.f5095d - i2;
            if (i3 > 0) {
                byte[] bArr = this.f5093b;
                System.arraycopy(bArr, i2, bArr, 0, i3);
            }
            this.f5094c = 0;
            this.f5095d = i3;
        }
        int i4 = this.f5095d;
        byte[] bArr2 = this.f5093b;
        int read = this.f5092a.read(bArr2, i4, bArr2.length - i4);
        if (read == -1) {
            return -1;
        }
        this.f5095d = i4 + read;
        this.j.a((long) read);
        return read;
    }

    public boolean f() {
        return this.f5094c < this.f5095d;
    }

    public int length() {
        return this.f5095d - this.f5094c;
    }

    public int read() {
        while (!f()) {
            if (e() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f5093b;
        int i2 = this.f5094c;
        this.f5094c = i2 + 1;
        return bArr[i2] & AVFrame.FRM_STATE_UNKOWN;
    }

    public int read(byte[] bArr, int i2, int i3) {
        int min;
        if (bArr == null) {
            return 0;
        }
        if (f()) {
            min = Math.min(i3, this.f5095d - this.f5094c);
            System.arraycopy(this.f5093b, this.f5094c, bArr, i2, min);
        } else if (i3 > this.i) {
            int read = this.f5092a.read(bArr, i2, i3);
            if (read > 0) {
                this.j.a((long) read);
            }
            return read;
        } else {
            while (!f()) {
                if (e() == -1) {
                    return -1;
                }
            }
            min = Math.min(i3, this.f5095d - this.f5094c);
            System.arraycopy(this.f5093b, this.f5094c, bArr, i2, min);
        }
        this.f5094c += min;
        return min;
    }
}
