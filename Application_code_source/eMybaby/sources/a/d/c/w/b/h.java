package a.d.c.w.b;

public enum h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3161a;

    /* access modifiers changed from: public */
    h(int[] iArr, int i) {
        this.f3161a = iArr;
    }

    public int f(i iVar) {
        int i = iVar.f3163a;
        return this.f3161a[i <= 9 ? 0 : i <= 26 ? (char) 1 : 2];
    }
}
