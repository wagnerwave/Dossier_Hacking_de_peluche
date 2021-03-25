package a.d.c.t.b;

import a.d.c.r.l.a;
import a.d.c.r.l.d;
import com.tutk.IOTC.AVFrame;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final a.d.c.r.l.c f3045a = new a.d.c.r.l.c(a.o);

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i5 / i6)];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & AVFrame.FRM_STATE_UNKOWN;
            }
        }
        try {
            this.f3045a.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (d unused) {
            throw a.d.c.d.f2863a;
        }
    }
}
