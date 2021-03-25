package a.i.a;

public enum q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f3649a;

    /* access modifiers changed from: public */
    q(int i) {
        this.f3649a = i;
    }

    public static boolean f(int i) {
        return (i & OFFLINE.f3649a) != 0;
    }
}
