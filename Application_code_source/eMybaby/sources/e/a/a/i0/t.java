package e.a.a.i0;

import e.a.a.l0.b;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public final int f5167a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5168b;

    /* renamed from: c  reason: collision with root package name */
    public int f5169c;

    public t(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i <= i2) {
            this.f5167a = i;
            this.f5168b = i2;
            this.f5169c = i;
        } else {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
    }

    public boolean a() {
        return this.f5169c >= this.f5168b;
    }

    public void b(int i) {
        if (i < this.f5167a) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pos: ");
            stringBuffer.append(i);
            stringBuffer.append(" < lowerBound: ");
            stringBuffer.append(this.f5167a);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (i <= this.f5168b) {
            this.f5169c = i;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("pos: ");
            stringBuffer2.append(i);
            stringBuffer2.append(" > upperBound: ");
            stringBuffer2.append(this.f5168b);
            throw new IndexOutOfBoundsException(stringBuffer2.toString());
        }
    }

    public String toString() {
        b bVar = new b(16);
        bVar.a('[');
        bVar.b(Integer.toString(this.f5167a));
        bVar.a('>');
        bVar.b(Integer.toString(this.f5169c));
        bVar.a('>');
        bVar.b(Integer.toString(this.f5168b));
        bVar.a(']');
        return bVar.toString();
    }
}
