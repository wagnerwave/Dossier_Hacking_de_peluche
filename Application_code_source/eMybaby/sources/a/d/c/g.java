package a.d.c;

import com.tutk.IOTC.AVFrame;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f2870a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2871b;

    public g(int i, int i2) {
        this.f2870a = i;
        this.f2871b = i2;
    }

    public abstract byte[] a();

    public abstract byte[] b(int i, byte[] bArr);

    public String toString() {
        int i = this.f2870a;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.f2871b);
        for (int i2 = 0; i2 < this.f2871b; i2++) {
            bArr = b(i2, bArr);
            for (int i3 = 0; i3 < this.f2870a; i3++) {
                byte b2 = bArr[i3] & AVFrame.FRM_STATE_UNKOWN;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
