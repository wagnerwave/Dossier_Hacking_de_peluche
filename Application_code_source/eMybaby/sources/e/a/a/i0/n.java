package e.a.a.i0;

import e.a.a.u;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class n implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final j f5159a;

    /* renamed from: b  reason: collision with root package name */
    public String f5160b;

    /* renamed from: c  reason: collision with root package name */
    public String f5161c;

    /* renamed from: d  reason: collision with root package name */
    public int f5162d;

    public n(j jVar) {
        if (jVar != null) {
            this.f5159a = jVar;
            this.f5162d = a(-1);
            return;
        }
        throw new IllegalArgumentException("Header iterator must not be null.");
    }

    public int a(int i) {
        String str;
        if (i < 0) {
            if (!this.f5159a.hasNext()) {
                return -1;
            }
            this.f5160b = this.f5159a.b().getValue();
            i = 0;
        } else if (i >= 0) {
            int length = this.f5160b.length();
            boolean z = false;
            while (!z && i < length) {
                char charAt = this.f5160b.charAt(i);
                if (charAt == ',') {
                    z = true;
                } else {
                    if (charAt == 9 || Character.isSpaceChar(charAt)) {
                        i++;
                    } else if (b(charAt)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Tokens without separator (pos ");
                        stringBuffer.append(i);
                        stringBuffer.append("): ");
                        stringBuffer.append(this.f5160b);
                        throw new u(stringBuffer.toString());
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Invalid character after token (pos ");
                        stringBuffer2.append(i);
                        stringBuffer2.append("): ");
                        stringBuffer2.append(this.f5160b);
                        throw new u(stringBuffer2.toString());
                    }
                }
            }
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Search position must not be negative: ");
            stringBuffer3.append(i);
            throw new IllegalArgumentException(stringBuffer3.toString());
        }
        if (i >= 0) {
            boolean z2 = false;
            while (!z2 && (str = this.f5160b) != null) {
                int length2 = str.length();
                while (!z2 && i < length2) {
                    char charAt2 = this.f5160b.charAt(i);
                    if (!(charAt2 == ',')) {
                        if (!(charAt2 == 9 || Character.isSpaceChar(charAt2))) {
                            if (b(this.f5160b.charAt(i))) {
                                z2 = true;
                            } else {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                stringBuffer4.append("Invalid character before token (pos ");
                                stringBuffer4.append(i);
                                stringBuffer4.append("): ");
                                stringBuffer4.append(this.f5160b);
                                throw new u(stringBuffer4.toString());
                            }
                        }
                    }
                    i++;
                }
                if (!z2) {
                    if (this.f5159a.hasNext()) {
                        this.f5160b = this.f5159a.b().getValue();
                        i = 0;
                    } else {
                        this.f5160b = null;
                    }
                }
            }
            if (!z2) {
                i = -1;
            }
            if (i < 0) {
                this.f5161c = null;
                return -1;
            } else if (i >= 0) {
                int length3 = this.f5160b.length();
                int i2 = i;
                do {
                    i2++;
                    if (i2 >= length3 || !b(this.f5160b.charAt(i2))) {
                        this.f5161c = this.f5160b.substring(i, i2);
                    }
                    i2++;
                    break;
                } while (!b(this.f5160b.charAt(i2)));
                this.f5161c = this.f5160b.substring(i, i2);
                return i2;
            } else {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Token start position must not be negative: ");
                stringBuffer5.append(i);
                throw new IllegalArgumentException(stringBuffer5.toString());
            }
        } else {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Search position must not be negative: ");
            stringBuffer6.append(i);
            throw new IllegalArgumentException(stringBuffer6.toString());
        }
    }

    public boolean b(char c2) {
        if (Character.isLetterOrDigit(c2)) {
            return true;
        }
        if (Character.isISOControl(c2)) {
            return false;
        }
        return !(" ,;=()<>@:\\\"/[]?{}\t".indexOf(c2) >= 0);
    }

    public String c() {
        String str = this.f5161c;
        if (str != null) {
            this.f5162d = a(this.f5162d);
            return str;
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public boolean hasNext() {
        return this.f5161c != null;
    }

    public final Object next() {
        return c();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
