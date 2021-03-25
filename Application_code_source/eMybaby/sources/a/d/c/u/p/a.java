package a.d.c.u.p;

import a.d.c.i;
import a.d.c.u.k;

public abstract class a extends k {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3076a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3077b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f3078c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f3079d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f3080e;
    public final int[] f;

    public a() {
        int[] iArr = new int[8];
        this.f3077b = iArr;
        this.f3078c = new float[4];
        this.f3079d = new float[4];
        this.f3080e = new int[(iArr.length / 2)];
        this.f = new int[(iArr.length / 2)];
    }

    public static int g(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static void h(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    public static void i(int[] iArr, float[] fArr) {
        int i = 0;
        float f2 = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f2) {
                f2 = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    public static boolean j(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f2 = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f2 < 0.7916667f || f2 > 0.89285713f) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 : iArr) {
            if (i4 > i3) {
                i3 = i4;
            }
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i3 < i2 * 10;
    }

    public static int k(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (k.d(iArr, iArr2[i], 102) < 51) {
                return i;
            }
        }
        throw i.f2874a;
    }
}
