package a.d.a.a.h.g;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;

public final class q8 {

    /* renamed from: a  reason: collision with root package name */
    public static final r8 f1900a = ((!(n8.h && n8.g) || t4.a()) ? new t8() : new v8());

    public static int a(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int b(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int c(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new s8(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static boolean d(byte[] bArr, int i, int i2) {
        return f1900a.a(0, bArr, i, i2) == 0;
    }

    public static int e(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int f(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        byte b3 = -1;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            byte b4 = bArr[i];
            if (b2 <= -12 && b4 <= -65) {
                b3 = b2 ^ (b4 << 8);
            }
            return b3;
        } else if (i3 == 2) {
            return e(b2, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }
}
