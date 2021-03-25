package a.d.a.a.h.g;

public final class t7 implements g7 {

    /* renamed from: a  reason: collision with root package name */
    public final i7 f1947a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1948b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f1949c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1950d;

    public t7(i7 i7Var, String str, Object[] objArr) {
        this.f1947a = i7Var;
        this.f1948b = str;
        this.f1949c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f1950d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f1950d = c2 | (charAt2 << i);
                return;
            }
        }
    }

    public final int a() {
        return (this.f1950d & 1) == 1 ? 1 : 2;
    }

    public final boolean b() {
        return (this.f1950d & 2) == 2;
    }

    public final i7 c() {
        return this.f1947a;
    }
}
