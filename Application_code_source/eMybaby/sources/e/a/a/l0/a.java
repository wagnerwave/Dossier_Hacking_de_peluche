package e.a.a.l0;

import java.io.Serializable;

public final class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f5181a;

    /* renamed from: b  reason: collision with root package name */
    public int f5182b;

    public a(int i) {
        if (i >= 0) {
            this.f5181a = new byte[i];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public void a(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("off: ");
                stringBuffer.append(i);
                stringBuffer.append(" len: ");
                stringBuffer.append(i2);
                stringBuffer.append(" b.length: ");
                stringBuffer.append(bArr.length);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            } else if (i2 != 0) {
                int i4 = this.f5182b + i2;
                if (i4 > this.f5181a.length) {
                    b(i4);
                }
                System.arraycopy(bArr, i, this.f5181a, this.f5182b, i2);
                this.f5182b = i4;
            }
        }
    }

    public final void b(int i) {
        byte[] bArr = new byte[Math.max(this.f5181a.length << 1, i)];
        System.arraycopy(this.f5181a, 0, bArr, 0, this.f5182b);
        this.f5181a = bArr;
    }

    public void c(int i) {
        if (i < 0 || i > this.f5181a.length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("len: ");
            stringBuffer.append(i);
            stringBuffer.append(" < 0 or > buffer len: ");
            stringBuffer.append(this.f5181a.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        this.f5182b = i;
    }
}
