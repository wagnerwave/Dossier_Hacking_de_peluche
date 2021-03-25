package e.a.a.l0;

import com.tutk.IOTC.AVFrame;
import java.io.Serializable;

public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public char[] f5183a;

    /* renamed from: b  reason: collision with root package name */
    public int f5184b;

    public b(int i) {
        if (i >= 0) {
            this.f5183a = new char[i];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public void a(char c2) {
        int i = this.f5184b + 1;
        if (i > this.f5183a.length) {
            f(i);
        }
        this.f5183a[this.f5184b] = c2;
        this.f5184b = i;
    }

    public void b(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.f5184b + length;
        if (i > this.f5183a.length) {
            f(i);
        }
        str.getChars(0, length, this.f5183a, this.f5184b);
        this.f5184b = i;
    }

    public void c(byte[] bArr, int i, int i2) {
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
                int i4 = this.f5184b;
                int i5 = i2 + i4;
                if (i5 > this.f5183a.length) {
                    f(i5);
                }
                while (i4 < i5) {
                    this.f5183a[i4] = (char) (bArr[i] & AVFrame.FRM_STATE_UNKOWN);
                    i++;
                    i4++;
                }
                this.f5184b = i5;
            }
        }
    }

    public void d(char[] cArr, int i, int i2) {
        int i3;
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > cArr.length) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("off: ");
                stringBuffer.append(i);
                stringBuffer.append(" len: ");
                stringBuffer.append(i2);
                stringBuffer.append(" b.length: ");
                stringBuffer.append(cArr.length);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            } else if (i2 != 0) {
                int i4 = this.f5184b + i2;
                if (i4 > this.f5183a.length) {
                    f(i4);
                }
                System.arraycopy(cArr, i, this.f5183a, this.f5184b, i2);
                this.f5184b = i4;
            }
        }
    }

    public void e(int i) {
        if (i > 0) {
            int length = this.f5183a.length;
            int i2 = this.f5184b;
            if (i > length - i2) {
                f(i2 + i);
            }
        }
    }

    public final void f(int i) {
        char[] cArr = new char[Math.max(this.f5183a.length << 1, i)];
        System.arraycopy(this.f5183a, 0, cArr, 0, this.f5184b);
        this.f5183a = cArr;
    }

    public int g(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = this.f5184b;
        if (i3 > i4) {
            i3 = i4;
        }
        if (i2 > i3) {
            return -1;
        }
        while (i2 < i3) {
            if (this.f5183a[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String h(int i, int i2) {
        return new String(this.f5183a, i, i2 - i);
    }

    public String i(int i, int i2) {
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Negative beginIndex: ");
            stringBuffer.append(i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (i2 > this.f5184b) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("endIndex: ");
            stringBuffer2.append(i2);
            stringBuffer2.append(" > length: ");
            stringBuffer2.append(this.f5184b);
            throw new IndexOutOfBoundsException(stringBuffer2.toString());
        } else if (i <= i2) {
            while (i < i2 && a.e.a.a.r.b.N(this.f5183a[i])) {
                i++;
            }
            while (i2 > i && a.e.a.a.r.b.N(this.f5183a[i2 - 1])) {
                i2--;
            }
            return new String(this.f5183a, i, i2 - i);
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("beginIndex: ");
            stringBuffer3.append(i);
            stringBuffer3.append(" > endIndex: ");
            stringBuffer3.append(i2);
            throw new IndexOutOfBoundsException(stringBuffer3.toString());
        }
    }

    public String toString() {
        return new String(this.f5183a, 0, this.f5184b);
    }
}
