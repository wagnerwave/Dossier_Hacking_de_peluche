package a.d.a.a.h.g;

import a.c.a.d.a;
import com.tutk.IOTC.AVFrame;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class j3 {
    public static int a(int i, int i2, int i3) {
        return (i & (i3 ^ -1)) | (i2 & i3);
    }

    public static int b(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & AVFrame.FRM_STATE_UNKOWN : obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static int c(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int t = a.t(obj);
        int i4 = t & i;
        int b2 = b(obj3, i4);
        if (b2 == 0) {
            return -1;
        }
        int i5 = i ^ -1;
        int i6 = t & i5;
        int i7 = -1;
        while (true) {
            i2 = b2 - 1;
            i3 = iArr[i2];
            if ((i3 & i5) != i6 || !a.z(obj, objArr[i2]) || (objArr2 != null && !a.z(obj2, objArr2[i2]))) {
                int i8 = i3 & i;
                if (i8 == 0) {
                    return -1;
                }
                int i9 = i8;
                i7 = i2;
                b2 = i9;
            }
        }
        int i10 = i3 & i;
        if (i7 == -1) {
            e(obj3, i4, i10);
        } else {
            iArr[i7] = a(iArr[i7], i10, i);
        }
        return i2;
    }

    public static Object d(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void e(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
