package e.a.a.g0.k;

import e.a.a.a0;
import e.a.a.h0.a;
import e.a.a.h0.c;
import e.a.a.l0.b;
import java.io.IOException;
import java.io.InputStream;

public class d extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final c f5097a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5098b;

    /* renamed from: c  reason: collision with root package name */
    public int f5099c;

    /* renamed from: d  reason: collision with root package name */
    public int f5100d;

    /* renamed from: e  reason: collision with root package name */
    public int f5101e;
    public boolean f = false;
    public boolean g = false;

    public d(c cVar) {
        if (cVar != null) {
            this.f5097a = cVar;
            this.f5101e = 0;
            this.f5098b = new b(16);
            this.f5099c = 1;
            return;
        }
        throw new IllegalArgumentException("Session input buffer may not be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            int r0 = r6.f5099c
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L_0x0035
            r4 = 3
            if (r0 != r4) goto L_0x002d
            e.a.a.l0.b r0 = r6.f5098b
            r0.f5184b = r2
            e.a.a.h0.c r4 = r6.f5097a
            int r0 = r4.b(r0)
            if (r0 != r1) goto L_0x0017
            goto L_0x0041
        L_0x0017:
            e.a.a.l0.b r0 = r6.f5098b
            int r0 = r0.f5184b
            if (r0 != 0) goto L_0x001f
            r0 = 1
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r6.f5099c = r3
            goto L_0x0035
        L_0x0025:
            e.a.a.r r0 = new e.a.a.r
            java.lang.String r1 = "Unexpected content at the end of chunk"
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Inconsistent codec state"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            e.a.a.l0.b r0 = r6.f5098b
            r0.f5184b = r2
            e.a.a.h0.c r4 = r6.f5097a
            int r0 = r4.b(r0)
            if (r0 != r1) goto L_0x0043
        L_0x0041:
            r0 = 0
            goto L_0x005f
        L_0x0043:
            e.a.a.l0.b r0 = r6.f5098b
            r4 = 59
            int r5 = r0.f5184b
            int r0 = r0.g(r4, r2, r5)
            if (r0 >= 0) goto L_0x0053
            e.a.a.l0.b r0 = r6.f5098b
            int r0 = r0.f5184b
        L_0x0053:
            e.a.a.l0.b r4 = r6.f5098b     // Catch:{ NumberFormatException -> 0x00a9 }
            java.lang.String r0 = r4.i(r2, r0)     // Catch:{ NumberFormatException -> 0x00a9 }
            r4 = 16
            int r0 = java.lang.Integer.parseInt(r0, r4)     // Catch:{ NumberFormatException -> 0x00a9 }
        L_0x005f:
            r6.f5100d = r0
            if (r0 < 0) goto L_0x00a1
            r4 = 2
            r6.f5099c = r4
            r6.f5101e = r2
            if (r0 != 0) goto L_0x00a0
            r6.f = r3
            e.a.a.h0.c r0 = r6.f5097a     // Catch:{ i -> 0x0079 }
            e.a.a.i0.i r4 = e.a.a.i0.i.f5145b     // Catch:{ i -> 0x0079 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ i -> 0x0079 }
            r5.<init>()     // Catch:{ i -> 0x0079 }
            e.a.a.g0.k.a.b(r0, r1, r1, r4, r5)     // Catch:{ i -> 0x0079 }
            goto L_0x00a0
        L_0x0079:
            r0 = move-exception
            e.a.a.r r1 = new e.a.a.r
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = "Invalid footer: "
            r4.append(r5)
            java.lang.String r5 = r0.getMessage()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r4)
            java.lang.reflect.Method r4 = e.a.a.l0.c.f5185a
            if (r4 == 0) goto L_0x009f
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x009f }
            r3[r2] = r0     // Catch:{ Exception -> 0x009f }
            r4.invoke(r1, r3)     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            throw r1
        L_0x00a0:
            return
        L_0x00a1:
            e.a.a.r r0 = new e.a.a.r
            java.lang.String r1 = "Negative chunk size"
            r0.<init>(r1)
            throw r0
        L_0x00a9:
            e.a.a.r r0 = new e.a.a.r
            java.lang.String r1 = "Bad chunk header"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.k.d.a():void");
    }

    public int available() {
        c cVar = this.f5097a;
        if (cVar instanceof a) {
            return Math.min(((a) cVar).length(), this.f5100d - this.f5101e);
        }
        return 0;
    }

    public void close() {
        if (!this.g) {
            try {
                if (!this.f) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f = true;
                this.g = true;
            }
        }
    }

    public int read() {
        if (this.g) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f) {
            return -1;
        } else {
            if (this.f5099c != 2) {
                a();
                if (this.f) {
                    return -1;
                }
            }
            int read = this.f5097a.read();
            if (read != -1) {
                int i = this.f5101e + 1;
                this.f5101e = i;
                if (i >= this.f5100d) {
                    this.f5099c = 3;
                }
            }
            return read;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.g) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f) {
            return -1;
        } else {
            if (this.f5099c != 2) {
                a();
                if (this.f) {
                    return -1;
                }
            }
            int read = this.f5097a.read(bArr, i, Math.min(i2, this.f5100d - this.f5101e));
            if (read != -1) {
                int i3 = this.f5101e + read;
                this.f5101e = i3;
                if (i3 >= this.f5100d) {
                    this.f5099c = 3;
                }
                return read;
            }
            this.f = true;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Truncated chunk ( expected size: ");
            stringBuffer.append(this.f5100d);
            stringBuffer.append("; actual size: ");
            stringBuffer.append(this.f5101e);
            stringBuffer.append(")");
            throw new a0(stringBuffer.toString());
        }
    }
}
