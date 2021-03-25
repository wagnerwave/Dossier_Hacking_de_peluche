package a.d.c.w.b;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final int[][] f3153c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3154d = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    /* renamed from: a  reason: collision with root package name */
    public final f f3155a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f3156b;

    public g(int i) {
        int i2 = (i >> 3) & 3;
        if (i2 >= 0) {
            f[] fVarArr = f.f3152e;
            if (i2 < fVarArr.length) {
                this.f3155a = fVarArr[i2];
                this.f3156b = (byte) (i & 7);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public static g a(int i, int i2) {
        int b2;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f3153c) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new g(iArr[1]);
            }
            int b3 = b(i, i5);
            if (b3 < i3) {
                i4 = iArr[1];
                i3 = b3;
            }
            if (i != i2 && (b2 = b(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = b2;
            }
        }
        if (i3 <= 3) {
            return new g(i4);
        }
        return null;
    }

    public static int b(int i, int i2) {
        int i3 = i ^ i2;
        int[] iArr = f3154d;
        return iArr[i3 & 15] + iArr[(i3 >>> 4) & 15] + iArr[(i3 >>> 8) & 15] + iArr[(i3 >>> 12) & 15] + iArr[(i3 >>> 16) & 15] + iArr[(i3 >>> 20) & 15] + iArr[(i3 >>> 24) & 15] + iArr[(i3 >>> 28) & 15];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3155a == gVar.f3155a && this.f3156b == gVar.f3156b;
    }

    public int hashCode() {
        return (this.f3155a.ordinal() << 3) | this.f3156b;
    }
}
