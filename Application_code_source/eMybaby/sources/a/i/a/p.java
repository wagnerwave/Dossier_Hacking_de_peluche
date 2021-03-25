package a.i.a;

public enum p {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f3644a;

    /* access modifiers changed from: public */
    p(int i) {
        this.f3644a = i;
    }

    public static boolean f(int i) {
        return (i & NO_CACHE.f3644a) == 0;
    }
}
